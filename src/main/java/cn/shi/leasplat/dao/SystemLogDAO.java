package cn.shi.leasplat.dao;

import java.util.List;

import cn.shi.leasplat.entity.SystemLog;

public interface SystemLogDAO {
	// ���ϵͳ��־��������Ҫ���ƣ���ʱ�ǲ���
	public Integer saveSystemLog(SystemLog log);
	
	// ��ҳ��ʾ
	public List<SystemLog> findPage(Integer limit, Integer offset);
	
	// ����
	public Integer getCount();
}
