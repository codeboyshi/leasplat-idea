package cn.shi.leasplat.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shi.leasplat.entity.AccessToken;
import cn.shi.leasplat.entity.User;

public interface AccessTokenService {
	//����token
	Integer saveAccessToken(AccessToken accessToken);
	//��ѯ��ǰ�û�token����
	Integer getCount(Integer userId);
	
	//ɾ����ǰ�û���½ǰӵ�е�����token
	void deleteByUserId(Integer userId);
	
	Boolean check(User user, String token, HttpServletRequest request, HttpServletResponse response);
}
