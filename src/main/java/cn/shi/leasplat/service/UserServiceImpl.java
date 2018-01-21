package cn.shi.leasplat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.shi.leasplat.dao.UserDao;
import cn.shi.leasplat.entity.User;
import cn.shi.leasplat.util.MD5;
import cn.shi.leasplat.util.Page;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource(name="userDao")  //ע������ID�� userDao
	private UserDao userDao;
	/**
	 * �û���¼��ⷽ��
	 */
	public User login(String name,String pwd,String checkCode,HttpServletRequest req){
		if(name==null || name == "" || pwd == null || pwd == "" || checkCode =="" || checkCode == null) throw new NameOrPasswordException("�û��������롢��֤�벻��Ϊ��");
		if(!name.matches("\\w{5,16}") || name.length()<5 || name.length()>16) throw new NameOrPasswordException("�˺���6-16λ��ĸ�����»������");
		if(!pwd.matches("\\w{5,16}") || pwd.length()<5 || pwd.length()>16) throw new NameOrPasswordException("������6-16λ��ĸ�����»������");
		User user=null;
		user=userDao.findUserByName(name);
		if(user==null){
			System.out.println("�û�������");
			throw new NameOrPasswordException("�û�������");
		}
		if(!checkCode.equals(req.getSession().getAttribute("checkCode"))) {
			throw new NameOrPasswordException("��֤�����");
		}
		String checkPass = MD5.encode(pwd +"ʯǿ̫˧��");
        if(!checkPass.equals(user.getPassword())) 
        {
        	System.out.println("���벻��ȷ");
        	throw new NameOrPasswordException("���벻��ȷ");
        }
		return user;
	}
	//ע��
	public Integer saveUser(User user,String repassword) {
		if(user.getUserName() == null ) throw new NameOrPasswordException("�˺Ų���Ϊ��");
		if(user.getPassword() == null || repassword == null|| user.getPassword() == "" || repassword == ""){
			throw new NameOrPasswordException("�����ȷ�����벻��Ϊ��");
		}
		if(!user.getPassword().equals(repassword))
		{  
			throw new NameOrPasswordException("������ȷ�����벻ͬ");
		}
		if(!user.getUserName().matches("\\w{5,16}") || user.getUserName().length()<5 || user.getUserName().length()>16) throw new NameOrPasswordException("�˺���5-16λ��ĸ�����»������");
		if(!user.getPassword().matches("\\w{5,16}") || user.getPassword().length()<5 || user.getPassword().length()>16) throw new NameOrPasswordException("������5-16λ��ĸ�����»������");
		User userCheck = findUserByName(user.getUserName());
		if(userCheck != null) throw new NameOrPasswordException("���û����Ѵ��ڣ���");
		user.setPassword(MD5.encode(user.getPassword()+"ʯǿ̫˧��"));
		return userDao.saveUser(user);
	}
	public Integer updateUser(User user) {
		
		return userDao.updateUser(user);
	}
	
	/**
	 * ����userName�����û�����������ʹ�ã�
	 * @return �ܱ�����
	 */
	public User findUserByName(String userName) {
		return userDao.findUserByName(userName);
	}
	
	/**
	 * �޸�����
	 */
	public Integer updatePwd(String password,String userName) {
		if(!password.matches("\\w{5,16}") || password.length()<5 || password.length()>16) throw new NameOrPasswordException("������6-16λ��ĸ�����»������");
		password = MD5.encode(password+"ʯǿ̫˧��");
		return userDao.updatePwd(password,userName);
	}
	
	public User findUserById(Integer id) {
		return userDao.findUserById(id);
	}
	
	public Integer info(User user) {
		return userDao.info(user);
	}
	public Page<User> findPage(Integer pageNo, Integer pageSize, String userName) {
		Page<User> page = new Page<User>(pageNo, pageSize);
		List<User> list = userDao.findPage(page.getLimit(), page.getOffset(), userName);
		Integer count = userDao.getCount(userName);
		page.setTotalCount(count);
		page.setResult(list);
		return page;
	}
	public void delete(Integer userId) {
		userDao.delete(userId);
	}
	public Map<String, List<Integer>> findCountByYear() {
		Date date = new Date();
		Integer year = date.getYear() + 1900;
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		List<Integer> yearCount = new ArrayList<Integer>();
		List<Integer> years = new ArrayList<Integer>();
		for (int i = year - 4;i <= year;i++)
		{
			Integer count = userDao.getCountByYear(i);
			yearCount.add(count);
			years.add(i);
		}
		map.put("years", years);
		map.put("yearCount", yearCount);
		return map;
	}
	
}
