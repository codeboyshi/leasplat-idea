package cn.shi.leasplat.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.shi.leasplat.entity.Goods;
import cn.shi.leasplat.entity.User;
import cn.shi.leasplat.util.Page;

/**
 * ����ӿ�
 */
public interface UserService {
	/**
	 * ��װ��¼�߼�
	 * �����¼�ɹ��ͷ��ص�¼�ĳɹ����û���Ϣ
	 * �����¼ʧ�ܾ��׳��쳣
	 * @param name �û���
	 * @param password ����
	 * @return ��¼�ɹ����û���Ϣ
	 * @throws NameOrPasswordException ��¼ʧ��
	 */
	User login(String name, String password,String checkCode,HttpServletRequest req);
	
	Integer saveUser(User user,String repassword);
	
	Integer updateUser(User user);
	
	User findUserByName(String userName);
	
	Integer updatePwd(String password,String userName);
	
	User findUserById(Integer id);
	
	Integer info(User user);
	
	Page<User> findPage(Integer pageNo, Integer pageSize, String userName);
	
	void delete(Integer userId);
	
	Map<String,List<Integer>> findCountByYear();
}
