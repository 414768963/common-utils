package com.bawei.wenqi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
	private static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM");
	private static SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
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
	
	/**  
	* @Title: isToday  
	* @Description: �ж�����������Ƿ���ͬһ��  
	* @param @param date
	* @param @return    �趨�ļ�  
	* @return boolean    ��������  
	*/
	public static boolean isToday(Date date) {
		
		if(simpleDateFormat.format(date).toString().equals(simpleDateFormat.format(new Date()).toString())) {
			return true;
		}
		
		return false;
	}
	
	/**  
	* @Title: isThisWeek  
	* @Description: ����һ�������ж��Ƿ��Ǳ���  
	* @param @param date
	* @param @return    �趨�ļ�  
	* @return boolean    ��������  
	*/
	public static boolean isThisWeek(Date date) {
		
		
	    Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());
	    System.out.println(firstDayOfWeek);
	    firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);
	    int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);
	    firstDayOfWeek.add(Calendar.DATE, -day+1+1);// �����+1����Ϊ�����տ�ʼ
	    // ����һ������
	    System.out.println(simpleDateFormat.format(firstDayOfWeek.getTime()));
	     
	    Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());
	    System.out.println(firstDayOfWeek);
	    lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);
	    day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);
	    lastDayOfWeek.add(Calendar.DATE, 7-day+1);
	    
	    // ���������������
	    System.out.println(simpleDateFormat.format(lastDayOfWeek.getTime()));
	    
	    return (date.getTime()<lastDayOfWeek.getTime().getTime() && date.getTime()>firstDayOfWeek.getTime().getTime() );
	}

	/**  
	* @Title: isToday  
	* @Description: �ж�����������Ƿ���ͬһ��
	* @param @param date
	* @param @return    �趨�ļ�  
	* @return boolean    ��������  
	*/
	public static boolean isThisMonth(Date date) {
		
		if(simpleDateFormat2.format(date).toString().equals(simpleDateFormat2.format(new Date()).toString())) {
			return true;
		}
		
		return false;
	}
	
	/**  
	* @Title: setDateToFirstDayOfThisMonth  
	* @Description: ��ʼ�������³���1��0ʱ0��0��0����
	* @param @param date
	* @param @return    �趨�ļ�  
	* @return String    ��������  
	*/
	public static Date setDateToFirstDayOfThisMonth(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.HOUR,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		
		
		return calendar.getTime();
	}
	
	public static void main(String[] args) throws Exception {
		Date parse = simpleDateFormat.parse("1999-12-06");
		System.out.println(simpleDateFormat3.format(setDateToFirstDayOfThisMonth(parse)));
		
	}
	
	
}
