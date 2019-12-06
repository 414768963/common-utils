package com.bawei.wenqi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/** 
 * @Title: DateUtil.java 
 * @Package com.bawei.wenqi.utils 
 * @Description: TODO(日期工具类) 
 * @author 文琪 
 * @date 2019年12月5日 
 * @version V1.0 
 */ 
public class DateUtil {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM");
	private static SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	/**  
	* @Title: getAge  
	* @Description: 根据日期计算年龄  
	* @param @param birthday
	* @param @return    设定文件  
	* @return int    返回类型  
	*/
	public static int getAge(Date birthday) {
		//获取日历控件
		Calendar calendar = Calendar.getInstance();
		//获取当前年月日
		int nowYear = calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH);
		int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
		//获取生日年月日
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
	* @Description: 计算开始日期与结束日期的天数差  
	* @param @return    设定文件  
	* @return int    返回类型  
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
	* @Description: 判断日期与今天是否是同一天  
	* @param @param date
	* @param @return    设定文件  
	* @return boolean    返回类型  
	*/
	public static boolean isToday(Date date) {
		
		if(simpleDateFormat.format(date).toString().equals(simpleDateFormat.format(new Date()).toString())) {
			return true;
		}
		
		return false;
	}
	
	/**  
	* @Title: isThisWeek  
	* @Description: 给定一个日期判断是否是本周  
	* @param @param date
	* @param @return    设定文件  
	* @return boolean    返回类型  
	*/
	public static boolean isThisWeek(Date date) {
		
		
	    Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());
	    System.out.println(firstDayOfWeek);
	    firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);
	    int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);
	    firstDayOfWeek.add(Calendar.DATE, -day+1+1);// 后面的+1是因为从周日开始
	    // 本周一的日期
	    System.out.println(simpleDateFormat.format(firstDayOfWeek.getTime()));
	     
	    Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());
	    System.out.println(firstDayOfWeek);
	    lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);
	    day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);
	    lastDayOfWeek.add(Calendar.DATE, 7-day+1);
	    
	    // 本周星期天的日期
	    System.out.println(simpleDateFormat.format(lastDayOfWeek.getTime()));
	    
	    return (date.getTime()<lastDayOfWeek.getTime().getTime() && date.getTime()>firstDayOfWeek.getTime().getTime() );
	}

	/**  
	* @Title: isToday  
	* @Description: 判断日期与今天是否是同一月
	* @param @param date
	* @param @return    设定文件  
	* @return boolean    返回类型  
	*/
	public static boolean isThisMonth(Date date) {
		
		if(simpleDateFormat2.format(date).toString().equals(simpleDateFormat2.format(new Date()).toString())) {
			return true;
		}
		
		return false;
	}
	
	/**  
	* @Title: setDateToFirstDayOfThisMonth  
	* @Description: 初始化到该月初的1日0时0分0秒0毫秒
	* @param @param date
	* @param @return    设定文件  
	* @return String    返回类型  
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
