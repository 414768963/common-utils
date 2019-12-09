package com.bawei.wenqi.utils;

import java.util.Iterator;
import java.util.Random;

/** 
 * @Title: StringUtil.java 
 * @Package com.bawei.wenqi.utils 
 * @Description: TODO(�ַ���������) 
 * @author ���� 
 * @date 2019��12��5�� 
 * @version V1.0 
 */ 
public class StringUtil {

	private static Random random = new Random();
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
	
	//�ж��ֻ������Ƿ�Ϊ��ֵ���Ƿ񳤶�Ϊ11λ����ʼλ������1.
	public static boolean judgeTelephoneIsOk(String src){
		String regex="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";	
		return src.matches(regex);
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

	/**  
	* @Title: isEmail  
	* @Description: TODO(�ж��Ƿ�ȫΪ����s)  
	* @param @param str
	* @param @return    �趨�ļ�  
	* @return boolean    ��������  
	*/
	public static boolean isAllLetters(String str) {
		String regex="[a-zA-Z]{1,}";
		return str.matches(regex);
		
	}
	
	/**  
	* @Title: getRandomAzChar  
	* @Description: ��ȡһ�������ĸ
	* @param @return    �趨�ļ�  
	* @return String    ��������  
	*/
	public static char getRandomAzChar() {
		int newChar = 'a' +random.nextInt(26);
		return (char)newChar;
	}
	
	/**  
	* @Title: getRandomNumChar  
	* @Description: ��ȡһ��0-9�����
	* @param @return    �趨�ļ�  
	* @return char    ��������  
	*/
	public static char getRandomNumChar() {
		int newChar = '0'+random.nextInt(10);
		return (char)newChar;
	}
	
	//����Ĳ���Ϊ���������Ӣ����ĸ����
	public static String getLetters(int num) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num; i++) {
			sb.append(getRandomAzChar());
		} 
		
		return sb.toString();
	}
	
	//����Ĳ���Ϊ���������Ӣ�ĺ������ַ�������
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
