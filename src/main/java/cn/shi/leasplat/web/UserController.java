package cn.shi.leasplat.web;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.shi.leasplat.annotation.Auditable;
import cn.shi.leasplat.entity.AccessToken;
import cn.shi.leasplat.entity.User;
import cn.shi.leasplat.service.AccessTokenService;
import cn.shi.leasplat.service.NameOrPasswordException;
import cn.shi.leasplat.service.UserService;
import cn.shi.leasplat.util.Captcha;
import cn.shi.leasplat.util.GetRand;
import cn.shi.leasplat.util.MD5;
import cn.shi.leasplat.util.Page;
import cn.shi.leasplat.util.Result;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@Autowired
	private AccessTokenService accessTokenService;
	
	//��ת��½����
	@RequestMapping("/toLogin.do")
	public String toLogin(Model model){
		return "/index";
	}
	
	//������֤��
	@RequestMapping("/checkCode.do")
	public String checkCode(Model model,HttpServletResponse res,HttpServletRequest req){
		try {
		 String checkCode = Captcha.generate(100, 40, res.getOutputStream());
		 req.getSession().setAttribute("checkCode", checkCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public Result login(String name,String password,
			HttpServletResponse res,HttpServletRequest req,@RequestParam(value = "checkCode") String checkCode) throws Exception{
		Result result = new Result();
		try {
			User user=userService.login(name, password,checkCode.toUpperCase(),req);
			if(accessTokenService.getCount(user.getUserId())>0){
				accessTokenService.deleteByUserId(user.getUserId());
			}
			AccessToken token = new AccessToken();
			token.setUserId(user.getUserId());
			token.setToken(MD5.encode(GetRand.getRand()+":::"+user.getUserId()));
			accessTokenService.saveAccessToken(token);
			user.setPassword(null);
			user.setSecretAnswer(null);
			user.setSecurity(null);
			result.setData(user);
			Cookie cookie = new Cookie("token", token.getToken());
			cookie.setPath("/");
			res.addCookie(cookie);
			Cookie c = new Cookie("userId",String.valueOf(user.getUserId()));
			c.setPath("/");
			res.addCookie(c);
			req.getSession().setAttribute("userAccount", name);
		} catch (Exception e) {
			e.printStackTrace();
			result.setError(e);
			result.getError().setCode(0);
			result.getError().setReason(e.getMessage());
			throw e;
		}finally{
			return result;
		}
		
	}
	
	//��תע�����
	@RequestMapping("/reg.do")
	public String toreg(Model model){
		return "/reg";
	}
	
	//ע��ǰ���˺��Ƿ�ռ�õļ��
	@RequestMapping("/isOccupy.do")
	@ResponseBody
	public Result occupy(@RequestParam String account){
		Result res = new Result();
		try {
			User user = userService.findUserByName(account);
			if(user != null)
			{
				res.getError().setCode(0);
				res.getError().setReason("ռ��");
				return res;
			}
			res.setData("����");
		} catch (Exception e) {
			e.printStackTrace();
			res.setError(e);
		}
		return res;
	}
	
	
	@RequestMapping("/save.do")
	@ResponseBody
	@Auditable(moduleName="�û�ģ��",operationName="ע��")
	public Result add(User user,@RequestParam String repassword,HttpServletRequest req){
		Result res = new Result();
		try {
			//System.out.println(user);
			userService.saveUser(user,repassword);
		} catch (Exception e) {
//			res.getError().setCode(0);
			res.setError(e);
//			res.getError().setReason("ϵͳ����");
		}
		
		return res;
	}
	
	
	//��������ģ��
	@RequestMapping("/forgetPwd.do")
	@ResponseBody
	public Result forgetPwd(@RequestParam String userName,
							Model model,
							HttpServletRequest req,
							HttpServletResponse response){
		Result res = new Result();
		
			try {
				User user = userService.findUserByName(userName);
				if(user.getSecurity() == null || "".equals(user.getSecurity()))
				{
					throw new NameOrPasswordException("���û�û�������ܱ����⣡");
				}
				req.getSession().setAttribute("security", user.getSecurity());
				req.getSession().setAttribute("secretanswer", user.getSecretAnswer());
				req.getSession().setAttribute("userName", userName);
				res.setData(user.getSecurity());
			} catch (Exception e) {
				e.printStackTrace();
				res.getError().setCode(0);
				res.getError().setReason("�޴��û�");
			}
		return res;
	}
	
	//��д�ܱ���,����ܱ����Ƿ���ȷ
	@RequestMapping("/check.do")
	@ResponseBody
	public Result checkSecretAnswer(Model model,@RequestParam String secretanswer,HttpServletRequest req,HttpServletResponse response){
		Result res = new Result();
		if(secretanswer == null){
			res.getError().setCode(0);
			res.getError().setReason("����д�ܱ���");
			return res;
		}
		
		if(!secretanswer.equals(req.getSession().getAttribute("secretanswer"))){
			res.getError().setCode(0);
			res.getError().setReason("����ȷ��д�ܱ���");
			return res;
		}
		
		return res;
	}
	
	//�޸����루ƾ���û����Լ�֮ǰ����֤��������޸ģ�
	@RequestMapping("/updatePwd.do")
	@ResponseBody
	@Auditable(moduleName="�û�����", operationName="�޸�����")
	public Result updatePwd(@RequestParam(value = "password") String password,HttpServletRequest req){
		Result res = new Result();
		try {
//			String userName = req.getParameter("userName");
			String userName = (String) req.getSession().getAttribute("userName");
			if(userName == null){
				res.getError().setCode(0);
				res.getError().setReason("�밴�ղ�����ȷִ��");
				return res;
			}
			userService.updatePwd(password, userName);
			req.getSession().removeAttribute("security");
			req.getSession().removeAttribute("secretanswer");
			req.getSession().removeAttribute("userName");
		} catch (Exception e) {
			e.printStackTrace();
			res.getError().setCode(0);
			res.getError().setReason("ϵͳ����");
		}
		return res;
	}
	
	@RequestMapping("/info.do")
	@ResponseBody
	public Result info(User user, HttpServletRequest request)
	{
		Result res = new Result(); 
		try {
			String userId = "";
			Cookie [] cookie = request.getCookies();
			for (int i = 0;i < cookie.length;i++)
			{
				if ("userId".equals(cookie[i].getName()))
				{
					userId = cookie[i].getValue();
				}
			}
			System.out.println(user);
			user.setUserId(Integer.parseInt(userId));
			userService.info(user);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	
	// ����Ա����
	@RequestMapping("/admin.do")
	public String toAdmin()
	{
		return "/html/manager";
	} 
	
	@RequestMapping("/list.do")
	@ResponseBody
	public Result findPage(@RequestParam Integer pageNo,
							@RequestParam Integer pageSize,
							@RequestParam(required = false) String userName)
	{
		Result res = new Result();
		try {
			Page<User> page = userService.findPage(pageNo, pageSize, userName);
			res.setData(page);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	
	
	// �����û�
	@RequestMapping("/delete.do")
	@ResponseBody
	@Auditable(moduleName="�û�����", operationName="�����û�")
	public Result delete(@RequestParam Integer userId)
	{
		Result res = new Result();
		try {
			userService.delete(userId);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	
	
	// �˳���¼
	@RequestMapping("/out.do")
	@ResponseBody
	public Result userOut(HttpServletRequest request,
							HttpServletResponse response)
	{
		Result res = new Result();
		try {
			request.getSession().invalidate();
			Cookie cookies[] = request.getCookies();
			for (Cookie cookie : cookies)
			{
				cookie = new Cookie(cookie.getName(),null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
			}
		} catch (Exception e) {
			res.setError(e);
		} 
		return res;
	}
}
