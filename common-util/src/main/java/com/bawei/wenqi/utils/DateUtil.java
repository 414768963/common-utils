package com.bawei.wenqi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
