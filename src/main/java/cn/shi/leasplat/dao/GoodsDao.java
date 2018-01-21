package cn.shi.leasplat.dao;

import java.util.List;

import cn.shi.leasplat.entity.Goods;

public interface GoodsDao {
	//��ѯ��ҳ---������Ʒ�����������
	public List<Goods> findPage(Integer limit, Integer offset, String name);
	//��ȡ������
	public Integer getCount(String name);
	//���
	public Integer save(Goods goods);
	//�޸�
	public Integer update(Goods goods);
	//ɾ��
	public Integer delete(Integer id);
	//��ѯһ������
	public Goods getById(Integer id);
	
	// ��ȡ��Ʒid
	public Integer getId();
	
	// ��ȡ��ǰ�û��ϴ�����Ʒ����
	public Integer getMyGoodsCount(Integer userId);
	
	// ��ȡ��ǰuser_id��������Ʒ
	public List<Goods> findMyGoods(Integer userId);
	
	// ��ȡ������Ʒ
	public List<Goods> findNewestGoods();
}
