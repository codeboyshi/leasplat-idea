package cn.shi.leasplat.service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import cn.shi.leasplat.dao.AccessTokenDao;
import cn.shi.leasplat.entity.AccessToken;
import cn.shi.leasplat.entity.User;

@Service
public class AccessTokenServiceImpl implements AccessTokenService{

	@Resource
	private AccessTokenDao accessTokenDao;
	/**
	 * ����token��ǩ
	 */
	public Integer saveAccessToken(AccessToken accessToken) {
		return accessTokenDao.saveToken(accessToken);
	}
	/**
	 * ��ѯ��ǰ�û����½ǰ�ڵ�����token����
	 */
	public Integer getCount(Integer userId) {
		return accessTokenDao.getCount(userId);
	}
	/**
	 * ɾ����ǰ�û����½ǰ�ڵ�����token
	 */
	public void deleteByUserId(Integer userId) {
		accessTokenDao.deleteByUserId(userId);
	}
	public Boolean check(User user, String token, HttpServletRequest request, HttpServletResponse response) {
		AccessToken accessToken = accessTokenDao.getByUserId(user.getUserId());
		if(accessToken.getToken().equals(token)) return true;
		request.getSession().invalidate();
		Cookie cookies[] = request.getCookies();
		for (Cookie cookie : cookies)
		{
			cookie = new Cookie(cookie.getName(),null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
		}
		return false;
	}

}
