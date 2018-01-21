package cn.shi.leasplat.dao;

import java.util.List;

import cn.shi.leasplat.entity.User;
/**
 * ��װ�û�User�����CRUD����
 * MapperScanner ��ɨ������ӿ�,�Զ�Ϊ�ӿڴ���
 * ʵ����,  ����ʵ�����ӿڵ�����Bean����
 */
public interface UserDao {
	/*
	 * id��ѯ
	 */
	public User findUserById(int userId); 
	/*
	 * �û�ע�᷽��
	 */
	public Integer saveUser(User user);
	/**
	 * ���ֲ�ѯ
	 */
	public User findUserByName(String userName);
	/**
	 * ���²���
	 * @return 
	 */
	public Integer updateUser(User user);
	
	public Integer updatePwd(String password,String userName);
	
	// �����û���Ϣ
	public Integer info(User user);
	
	// �����û���Ϣ��ʾ
	public List<User> findPage(Integer limit, Integer offset, String userName);
	
	public Integer getCount(String userName);
	
	public void delete(Integer userId);
	
	public Integer getCountByYear(Integer year);
}
