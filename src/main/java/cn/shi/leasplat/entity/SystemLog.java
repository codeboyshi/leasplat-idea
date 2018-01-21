package cn.shi.leasplat.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author shiqiang
 *
 */
public class SystemLog implements Serializable{
	private Integer id;						
	private String moduleName;				// ģ������
	private String operationName;			// ��������
	private Date createTime = new Date();	// ����ʱ��
	private Integer userId;					// �û�id
	
	// ���������ݿ�����
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "SystemLog [id=" + id + ", moduleName=" + moduleName + ", operationName=" + operationName
				+ ", createTime=" + createTime + ", userId=" + userId + "]";
	}
	
	
}
