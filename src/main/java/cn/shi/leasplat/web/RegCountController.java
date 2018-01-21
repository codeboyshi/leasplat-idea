package cn.shi.leasplat.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.shi.leasplat.service.UserService;
import cn.shi.leasplat.util.Result;

@Controller
@RequestMapping("count")
public class RegCountController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("reg.do")
	public String countView()
	{
		return "/html/statistics";
	}
	
	// ��ȡ5����ÿ���ע������
	@RequestMapping("/regMsg.do")
	@ResponseBody
	public Result regCount()
	{
		Result res = new Result();
		try {
			Map<String, List<Integer>> map = userService.findCountByYear();
			res.setData(map);
		} catch (Exception e) {
			res.setError(e);
		}
		return res;
	}
	// ����userService����ѯ�����ע���������Ȼ�ȡ���꣬Ȼ�����ͳ�Ƴ������Ȼ��ֱ���������list�
	//һ��listװ��ݣ���һ��listװ��Ӧ����ݵ�ע������
	
}
