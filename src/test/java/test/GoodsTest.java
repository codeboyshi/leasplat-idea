package test;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.shi.leasplat.entity.Goods;
import cn.shi.leasplat.service.GoodsService;
import cn.shi.leasplat.util.Page;

public class GoodsTest {

	ApplicationContext ac;
	@Before
	public void init(){
		 ac=new ClassPathXmlApplicationContext(
				"spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	
//	@Test
	/**
	 * ������Ʒ���
	 */
	public  void save(){
		Goods goods = new Goods();
		goods.setUserId(1);
		goods.setBasicUnit(1);//(0��,1��,2��)
		goods.setGoodsClassId(1);
//		goods.setGoodsImageId(1);
		goods.setName("���ܣ�Canon��EOS 5DS �����");
		goods.setGoodsMessage("");
		goods.setPrice(new BigDecimal(12));//��ԪΪ��λ
		GoodsService goodsService = ac.getBean("goodsService",GoodsService.class);
		Integer count = goodsService.save(goods);
		System.out.println(count);
	}

//	@Test
	/**
	 * ��ѯһ������
	 */
	public void getById(){
		GoodsService goodsService = ac.getBean("goodsService",GoodsService.class);
		Goods goods = goodsService.getById(1);
		System.out.println(goods);
	}
	/**
	 * ����ɾ��
	 */
//	@Test
	public void delete()
	{
		GoodsService goodsService = ac.getBean("goodsService",GoodsService.class);
		Integer count = goodsService.delete(1);
		System.out.println(count);
	}
	
//	@Test
	/**
	 * �����޸�
	 */
	public void update(){
		GoodsService goodsService = ac.getBean("goodsService",GoodsService.class);
		Goods goods = new Goods();
		goods.setId(1);
		goods.setUserId(1);
		goods.setBasicUnit(0);//(0��,1��,2��)
		goods.setGoodsClassId(1);
//		goods.setGoodsImageId(1);
		goods.setName("ƻ������");
		goods.setPrice(new BigDecimal(12));//��ԪΪ��λ
		Integer count = goodsService.update(goods);
		System.out.println(count);
	}
	
//	@Test
	public void getCount()
	{
		GoodsService goodsService = ac.getBean("goodsService",GoodsService.class);
		Integer count = goodsService.getCount("ƻ������");
		System.out.println(count);
	}
	
	/**
	 * ���Է�ҳ����
	 */
//	@Test
	public void findPage(){
		GoodsService goodsService = ac.getBean("goodsService",GoodsService.class);
		Page<Goods> page = goodsService.findPage(1, 10, "ƻ������");
		System.out.println(page.getResult().size());
	}
}
