package cn.shi.leasplat.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5���ܹ�����(���μ���)
 */
public class Utils {
	private static final String 
		SALT="ʯǿ��˧��û�취";
	
	public static String md5salt(String pwd){
		return DigestUtils.md5Hex(pwd+SALT);
	}
}


