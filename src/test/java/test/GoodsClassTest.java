package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.shi.leasplat.entity.GoodsClass;
import cn.shi.leasplat.service.GoodsClassService;

public class GoodsClassTest {

	ApplicationContext ac;
	@Before
	public void init(){
		 ac=new ClassPathXmlApplicationContext(
				"spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	
	/**
	 * ���Բ�����Ʒ���
	 */
//	@Test
	public void save()
	{
		GoodsClass goodsClass = new GoodsClass();
		goodsClass.setName("����");
		GoodsClassService goodsClassService = ac.getBean("goodsClassService",GoodsClassService.class);
		Integer count = goodsClassService.save(goodsClass);
		System.out.println(count);
	}
	/**
	 * ���Բ�ѯ
	 */
	@Test
	public void findAll()
	{
		GoodsClassService goodsClassService = ac.getBean("goodsClassService",GoodsClassService.class);
		List<GoodsClass> list = goodsClassService.findAll();
		System.out.println(list);
	}
}
