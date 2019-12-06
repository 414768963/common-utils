package com.bawei.wenqi.utils;

import java.io.File;

public class FileUtil {

	/**  
	* @Title: fileExtendName  
	* @Description: ��ȡ�ļ���չ��
	* @param @param fileName
	* @param @return    �趨�ļ�  
	* @return String    ��������  
	*/
	public static String fileExtendName(String fileName) {
		
		if(fileName!=null && !fileName.equals("")) {
			return fileName.substring(fileName.lastIndexOf("."));
		}
		
		return "�ļ�Ϊ��";
	}
	
	/**  
	* @Title: getSystemUserHome  
	* @Description: ��ȡϵͳ��ǰ�û�Ŀ¼
	* @param @return    �趨�ļ�  
	* @return String    ��������  
	*/
	public static String getSystemUserHome() {
		return System.getProperty("user.home");
	}
	
	
	/**
	 * @Title: deleteFile   
	 * @Description: �ݹ�ɾ���ļ�   
	 * @param: @param file      
	 * @return: void      
	 * @throws
	 */
	public static void deleteFile(File file) {
		if(file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File theFile : listFiles) {
				deleteFile(theFile);
			}
			file.delete();
		}else {
			file.delete();
		}
	}
	
	//ɾ���ļ���������
	public static void deleteFile(String filePath) {
		deleteFile(new File(filePath));
	}
	
	/**  
	* @Title: fileSize  
	* @Description: ����ļ���С(kb)
	* @param @param file
	* @param @return    �趨�ļ�  
	* @return String    ��������  
	*/
	public static String fileSize(File file) {
		if(file.exists() && file.isFile()) {
			long length = file.length();
			double len = length/1024.0;
			return String.format("%.2f", len)+"kb";
		}
		return "�ļ�������";
	}
	

	//�ļ���С����
	public static String fileSize(String file) {
		return fileSize(new File(file));
	}
	
	public static void main(String[] args) {
		System.out.println(fileSize("D:\\WorkSpace\\cms\\.metadata\\.log"));
	}
}
