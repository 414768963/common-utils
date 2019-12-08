package com.bawei.wenqi.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/** 
 * @Title: StreamUtil.java 
 * @Package com.bawei.wenqi.utils 
 * @Description: ��������
 * @author ���� 
 * @date 2019��12��6�� 
 * @version V1.0 
 */ 
public class StreamUtil {

	/**  
	* @Title: closeAll  
	* @Description: �ر������ɹرն��
	* @param @param autoCloseables    �趨�ļ�  
	* @return void    ��������  
	*/
	public static void closeAll(AutoCloseable... autoCloseables ) {
		if(autoCloseables!=null) {
			for (AutoCloseable autoCloseable : autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**  
	* @Title: ReadFileByLine  
	* @Description: ���ж�ȡ�ļ�
	* @param @param filename
	* @param @return    �趨�ļ�  
	* @return String    ��������  
	*/
	public static void ReadFileByLine(String filename) {
		 File file = new File(filename);
         InputStream is = null;
         Reader reader = null;
         BufferedReader bufferedReader = null;
         
         try {
			is = new FileInputStream(file);
	        reader = new InputStreamReader(is);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(is,reader,bufferedReader);
		}
	}
	
	/**
	 * @Title: readTextFileOfList   
	 * @Description: ���ж�ȡ�ļ����ݵ�list����   
	 * @param: @param pathname
	 * @param: @return      
	 * @return: List<String>      
	 * @throws
	 */
	public static List<String> readTextFileOfList(String pathname) {
		BufferedReader br = null;
		List<String> strList = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(new File(pathname)));
			do {
				strList.add(br.readLine());
			}while(br.read()!=-1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			StreamUtil.closeAll(br);
		}
		return strList;
	}
	
	/**  
	* @Title: ReadFileByBytes  
	* @Description: �ֽڶ�ȡ�ļ�  
	* @param @param filename    �趨�ļ�  
	* @return void    ��������  
	*/
	public static void ReadFileByBytes(String filename) {
		File file = new File(filename);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			int index = 0;
			byte[] tempbyte = new byte[1024];
			while((index=inputStream.read(tempbyte))!=-1) {
				System.out.write(tempbyte,0,index);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(inputStream);
		}
	}
	
	public static void main(String[] args) {
		ReadFileByBytes("D:\\����ͨ�ļ�\\java\\Сһ\\����\\common-utils\\src\\main\\java\\com\\zhanggm\\common\\utils\\StreamUtil.java");
	}
}
