package cn.shi.leasplat.service;

import java.util.List;

import cn.shi.leasplat.entity.Message;
import cn.shi.leasplat.util.Page;

public interface MessageService {
		//��������
		Integer save(Message message);
		//����idɾ������
		void deleteById(Integer id);
		//ɾ��ȫ������
		void deleteAll();
		//��ҳ�������ԣ���ʾ���ǵ��������
		Page<Message> findPage(Integer pageNo,Integer pageSize);
}
