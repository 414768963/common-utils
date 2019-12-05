package com.bawei.wenqi.utils;

/** 
 * @Title: StringUtil.java 
 * @Package com.bawei.wenqi.utils 
 * @Description: TODO(字符串工具类) 
 * @author 文琪 
 * @date 2019年12月5日 
 * @version V1.0 
 */ 
public class StringUtil {

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
	
	public static void main(String[] args) {
		System.out.println(isEmail("414768963@qq.com"));
	}
}
