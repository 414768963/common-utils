package com.bawei.wenqi.utils;

/** 
 * @Title: StringUtil.java 
 * @Package com.bawei.wenqi.utils 
 * @Description: TODO(�ַ���������) 
 * @author ���� 
 * @date 2019��12��5�� 
 * @version V1.0 
 */ 
public class StringUtil {

	/**  
	* @Title: isBlank  
	* @Description: TODO(�ж��ַ����Ƿ�Ϊ��)  
	* @param @param str
	* @param @return    �趨�ļ�  
	* @return boolean    ��������  
	*/
	public static boolean isBlank(String str) {
		
		//Ϊ�շ���true
		if(str==null || str.equals("") || str.trim().length()==0) {
			return true;
		}
		
		//��Ϊ�շ���false
		return false;
	}
	
	/**  
	* @Title: isNotBlank  
	* @Description: TODO(�ж��Ƿ���ֵ)  
	* @param @param str
	* @param @return    �趨�ļ�  
	* @return boolean    ��������  
	*/
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	
	/**  
	* @Title: isPhoneNum  
	* @Description: TODO(�ж��Ƿ����ֻ���)  
	* @param @param str
	* @param @return    �趨�ļ�  
	* @return boolean    ��������  
	*/
	public static boolean isPhoneNum(String str) {
		String regex="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		return str.matches(regex);
		
	}
	
	/**  
	* @Title: isEmail  
	* @Description: TODO(�ж��Ƿ�Ϊ�����˺�)  
	* @param @param str
	* @param @return    �趨�ļ�  
	* @return boolean    ��������  
	*/
	public static boolean isEmail(String str) {
		String regex="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		return str.matches(regex);
		
	}
	
	public static void main(String[] args) {
		System.out.println(isEmail("414768963@qq.com"));
	}
}
