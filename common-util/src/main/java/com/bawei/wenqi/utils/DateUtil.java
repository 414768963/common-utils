package com.bawei.wenqi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
 * @Title: DateUtil.java 
 * @Package com.bawei.wenqi.utils 
 * @Description: TODO(���ڹ�����) 
 * @author ���� 
 * @date 2019��12��5�� 
 * @version V1.0 
 */ 
public class DateUtil {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	/**  
	* @Title: getAge  
	* @Description: �������ڼ�������  
	* @param @param birthday
	* @param @return    �趨�ļ�  
	* @return int    ��������  
	*/
	public static int getAge(Date birthday) {
		//��ȡ�����ؼ�
		Calendar calendar = Calendar.getInstance();
		//��ȡ��ǰ������
		int nowYear = calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH);
		int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
		//��ȡ����������
		calendar.setTime(birthday);
		int birthYear = calendar.get(Calendar.YEAR);
		int birthMonth = calendar.get(Calendar.MONTH);
		int birthDay = calendar.get(Calendar.DAY_OF_MONTH);
		
		int age = nowYear-birthYear;
		
		if(nowMonth<birthMonth) {
			age--;
		}
		if(nowMonth==birthMonth && nowDay<birthDay) {
			age--;
		}
		return age;
	}
	
	/**  
	* @Title: getDays  
	* @Description: ���㿪ʼ������������ڵ�������  
	* @param @return    �趨�ļ�  
	* @return int    ��������  
	*/
	public static int getDays(Date date1,Date date2) {
		
		long dayTime = 1000*60*60*24L;
		long beginDate = date1.getTime();
		long endDate = date2.getTime();
		
		double days = Math.floor(Math.abs((endDate-beginDate)/(dayTime*1.0)));
		
		return (int) days;
	}
	
	public static boolean isToday(Date date) {
		
		if(simpleDateFormat.format(date).toString().equals(simpleDateFormat.format(new Date()).toString())) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		Date parse = simpleDateFormat.parse("1999-12-05");
		System.out.println(getAge(parse));
	}
	
	
}
