package cn.shi.leasplat.service;


import java.util.List;

import cn.shi.leasplat.entity.Goods;
import cn.shi.leasplat.util.Page;

public interface GoodsService {
	
	/**
	 * ��ҳ����Ʒ
	 * ��Ҫ��Ӳ�ѯ����
	 * 1.��Ʒ������
	 * 2.��Ʒ����ģ������
	 * 3.������ʱ�������������
	 * @param pageNo
	 * @param pageSize
	 * @param name (��Ʒ���ƻ���Ʒ���)
	 * @return
	 */
	Page<Goods> findPage(Integer pageNo, Integer pageSize, String name);
	
	Integer getCount(String name);
	
	Integer save(Goods goods);
	
	Integer update(Goods goods);
	
	Integer delete(Integer id);
	
	Goods getById(Integer id);
	
	Integer getId();
	
	Integer getMyGoodsCount(Integer userId);
	
	List<Goods> findMyGoods(Integer userId);
	
	List<Goods> findNewestGoods();
}
