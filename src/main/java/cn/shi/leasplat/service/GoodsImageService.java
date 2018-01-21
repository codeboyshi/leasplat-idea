package cn.shi.leasplat.service;

import java.util.List;

import cn.shi.leasplat.entity.GoodsImage;

public interface GoodsImageService {
	List<GoodsImage> findByGoodsId(Integer goodsId);
	
	void delete(Integer id);
	
	Integer update(GoodsImage goodsImage);
	
	Integer save(GoodsImage goodsImage);
	/**
	 * ��ѯĳһ��Ʒ������ͼƬ�е�һ��
	 * @param goodsId
	 * @return
	 */
	GoodsImage getByGoodsId(Integer goodsId);
	
	GoodsImage getById(Integer id);
	
	void deleteByGoodsId(Integer goodsId);
}
