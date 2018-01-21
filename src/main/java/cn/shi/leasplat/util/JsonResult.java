package cn.shi.leasplat.util;

import java.io.Serializable;

/**
 * ���ڴ洢json����ֵ��û�����ϣ�����ʹ��result�ཫ�������
 */
public class JsonResult<T> 
	implements Serializable{
	public static final int SUCCESS=0;
	public static final int ERROR=1;
	
	private int state;
	private String message = "";
	private T data;
	
	public JsonResult() {
		state = SUCCESS;
	}
	//���ڷ�װ���������ͻ��˵�Json����ֵ
	public JsonResult(
		int state, String message, T data) {
		this.state = state;
		this.message = message;
		this.data = data;
	}
	public JsonResult(String error){
		this(ERROR, error, null);
	}
	public JsonResult(T data){
		this(SUCCESS, "", data);
	}
	public JsonResult(int state){
		this(state, "", null);
	}
	public JsonResult(Throwable e){
		this(ERROR, e.getMessage(), null);
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
}













