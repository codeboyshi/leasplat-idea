package cn.shi.leasplat.dao;

import cn.shi.leasplat.entity.AccessToken;

public interface AccessTokenDao {
	//����token
	public Integer saveToken(AccessToken accesstoken);
	
	//��ѯ��ǰ�û��Ƿ���token����
	public Integer getCount(Integer userId);
	
	public void deleteByUserId(Integer userId);
	
	public AccessToken getByUserId(Integer userId);
}
