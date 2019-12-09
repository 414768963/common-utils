package com.bawei.wenqi.utils;

import java.util.Iterator;
import java.util.Random;

/** 
 * @Title: StringUtil.java 
 * @Package com.bawei.wenqi.utils 
 * @Description: TODO(字符串工具类) 
 * @author 文琪 
 * @date 2019年12月5日 
 * @version V1.0 
 */ 
public class StringUtil {

	private static Random random = new Random();
	/**  
	* @Title: isBlank  
	* @Description: TODO(判断字符串是否为空)  
	* @param @param str
	* @param @return    设定文件  
	* @return boolean    返回类型  
	*/
	public static boolean isBlank(String str) {
		
		//为空返回true
		if(str==null || str.equals("") || str.trim().length()==0) {
			return true;
		}
		
		//不为空返回false
		return false;
	}
	
	/**  
	* @Title: isNotBlank  
	* @Description: TODO(判断是否有值)  
	* @param @param str
	* @param @return    设定文件  
	* @return boolean    返回类型  
	*/
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	
	/**  
	* @Title: isPhoneNum  
	* @Description: TODO(判断是否是手机号)  
	* @param @param str
	* @param @return    设定文件  
	* @return boolean    返回类型  
	*/
	public static boolean isPhoneNum(String str) {
		String regex="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		return str.matches(regex);
		
	}
	
	//判断手机号码是否为数值，是否长度为11位，开始位必须是1.
	public static boolean judgeTelephoneIsOk(String src){
		String regex="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";	
		return src.matches(regex);
	}

	
	/**  
	* @Title: isEmail  
	* @Description: TODO(判断是否为邮箱账号)  
	* @param @param str
	* @param @return    设定文件  
	* @return boolean    返回类型  
	*/
	public static boolean isEmail(String str) {
		String regex="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		return str.matches(regex);
		
	}

	/**  
	* @Title: isEmail  
	* @Description: TODO(判断是否全为数字s)  
	* @param @param str
	* @param @return    设定文件  
	* @return boolean    返回类型  
	*/
	public static boolean isAllLetters(String str) {
		String regex="[a-zA-Z]{1,}";
		return str.matches(regex);
		
	}
	
	/**  
	* @Title: getRandomAzChar  
	* @Description: 获取一个随机字母
	* @param @return    设定文件  
	* @return String    返回类型  
	*/
	public static char getRandomAzChar() {
		int newChar = 'a' +random.nextInt(26);
		return (char)newChar;
	}
	
	/**  
	* @Title: getRandomNumChar  
	* @Description: 获取一个0-9随机数
	* @param @return    设定文件  
	* @return char    返回类型  
	*/
	public static char getRandomNumChar() {
		int newChar = '0'+random.nextInt(10);
		return (char)newChar;
	}
	
	//传入的参数为产生的随机英文字母个数
	public static String getLetters(int num) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num; i++) {
			sb.append(getRandomAzChar());
		} 
		
		return sb.toString();
	}
	
	//传入的参数为产生的随机英文和数字字符串长度
	public static String getLettersOrNum(int num) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num; i++) {
			if(random.nextInt(36)>10) {
				sb.append(getRandomAzChar());
			}else {
				sb.append(getRandomNumChar());
			}
		} 
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getLettersOrNum(10));
	}
}
