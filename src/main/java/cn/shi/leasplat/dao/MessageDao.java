package cn.shi.leasplat.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.shi.leasplat.entity.Message;
@Repository
public interface MessageDao {

	/**
	 * ����һ������
	 * @param message
	 * @return
	 */
	Integer save(Message message);
	
	/**
	 * ��ҳ��������
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Message> findPage(Integer limit,Integer offset);
	/**
	 * ����idɾ��һ������
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * ɾ��ȫ������
	 */
	void deleteAll();
	/**
	 * ��ȡ���Ը���
	 * @return
	 */
	Integer getCount();
}
