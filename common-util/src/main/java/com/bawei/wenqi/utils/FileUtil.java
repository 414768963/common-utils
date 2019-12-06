package com.bawei.wenqi.utils;

import java.io.File;

public class FileUtil {

	/**  
	* @Title: fileExtendName  
	* @Description: 获取文件扩展名
	* @param @param fileName
	* @param @return    设定文件  
	* @return String    返回类型  
	*/
	public static String fileExtendName(String fileName) {
		
		if(fileName!=null && !fileName.equals("")) {
			return fileName.substring(fileName.lastIndexOf("."));
		}
		
		return "文件为空";
	}
	
	/**  
	* @Title: getSystemUserHome  
	* @Description: 获取系统当前用户目录
	* @param @return    设定文件  
	* @return String    返回类型  
	*/
	public static String getSystemUserHome() {
		return System.getProperty("user.home");
	}
	
	
	/**
	 * @Title: deleteFile   
	 * @Description: 递归删除文件   
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
	
	//删除文件方法重载
	public static void deleteFile(String filePath) {
		deleteFile(new File(filePath));
	}
	
	/**  
	* @Title: fileSize  
	* @Description: 获得文件大小(kb)
	* @param @param file
	* @param @return    设定文件  
	* @return String    返回类型  
	*/
	public static String fileSize(File file) {
		if(file.exists() && file.isFile()) {
			long length = file.length();
			double len = length/1024.0;
			return String.format("%.2f", len)+"kb";
		}
		return "文件不存在";
	}
	

	//文件大小重载
	public static String fileSize(String file) {
		return fileSize(new File(file));
	}
	
	public static void main(String[] args) {
		System.out.println(fileSize("D:\\WorkSpace\\cms\\.metadata\\.log"));
	}
}
