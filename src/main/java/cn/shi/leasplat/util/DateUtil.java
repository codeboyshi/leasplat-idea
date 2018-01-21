package cn.shi.leasplat.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Title:        DateUtil
 * 
 * @Description:  ʱ��ת����
 * 
 * @author        ʯǿ
 * 
 * @Date          2017��2��2��
 * 
 * @version       1.0
 * 
 */
public class DateUtil {
	
	/**
	 * ��ȡ��ǰ����-�ַ���
	 * @return ������
	 */
	public static String getToDate(){
		SimpleDateFormat ss = new SimpleDateFormat("yyyyMMdd");
		return ss.format(new Date());
	}
	
	/**
	 * ��ȡ��ǰ����-�ַ���
	 * @return ������
	 */
	public static String getToDateLine(){
		SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");
		return ss.format(new Date());
	}

	/**
	 * ��ȡ����-�ַ���
	 * @return ������
	 */
	public static String getToDateUK(String str) throws ParseException{
		SimpleDateFormat sdf1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
		Date date = sdf1.parse(str);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * ��ȡ����-�ַ���
	 * @param date ����
	 * @return ������
	 */
	public static String getDate(Date date){
		SimpleDateFormat ss = new SimpleDateFormat("yyyyMMdd");
		return ss.format(date);
	}
	
	/**
	 * ��ȡ����-�ַ���
	 * @param date ����
	 * @return ��-��-��
	 */
	public static String getDateLine(Date date){
		SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");
		return ss.format(date);
	}

	/**
	 * ��ȡ����-�ַ���
	 * @param date ����
	 * @return ��-��-��
	 */
	public static String getDateStr(Date date){
		SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return ss.format(date);
	}
	
	/**
	 * ��ȡʱ��-�ַ���
	 * @return ʱ:��:��
	 */
	public static String getTime(){
		SimpleDateFormat ss = new SimpleDateFormat("HH:mm:ss");
		return ss.format(new Date());
	}
	
	/**
	 * ��ȡ����ʱ��-�ַ���
	 * @return ��-��-�� ʱ:��:��
	 */
	public static String getDateTime(){
		SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return ss.format(new Date());
	}
	
	/**
	 * �Ƚ����ڴ�С ���������ڽϴ��-�ַ���
	 * @param date1 ����1
	 * @param date2 ����2
	 * @return ������
	 */
	public static String equalsDate(Date date1,Date date2){
		SimpleDateFormat ss = new SimpleDateFormat("yyyyMMdd");
		String dateStr1 = ss.format(date1);
		String dateStr2 = ss.format(date2);
		if(Integer.parseInt(dateStr1) - Integer.parseInt(dateStr2) > 0){
			return dateStr1;
		}
		return dateStr2;
	}
	
	
	/**
	 * ���������� ����������-�ַ���
	 * @param date1 ����1
	 * @param date2 ����2
	 * @return ����
	 * @throws ParseException
	 */
	public static String mistakeDate(String date1,Date date2) throws ParseException{
		SimpleDateFormat ss = new SimpleDateFormat("yyyyMMdd");
		String dateStr2 = ss.format(date2);
		long dateOne = ss.parse(date1).getTime();
		long dateTwo = ss.parse(dateStr2).getTime();
		int days = (int) ((dateTwo - dateOne)/(1000*60*60*24));	
		return Math.abs(days)+"";
	}

	/**
	 *	����ʽ�����ַ���ת����ʱ���
	 * @param dateTime
	 * @return ʱ���
	 * @throws ParseException
	 */
	public static Long getLongTime(String dateTime) throws ParseException{
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(dateTime);
		return date.getTime();
	}

	/*public static void main(String args[]) throws ParseException {
		System.out.println(DateUtil.getToDateUK(""));
	}*/
}

