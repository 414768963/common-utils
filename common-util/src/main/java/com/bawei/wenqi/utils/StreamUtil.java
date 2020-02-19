package com.bawei.wenqi.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
/**
 * 流工具类
 * @Description:TODO(描述这个类的作用)   
 * @author: wenqi
 * @date:   2019年12月5日 下午1:31:39
 */
public class StreamUtil {
	/**
	 * 关闭流的方法
	 * @Title: closeAll   
	 * @Description: 数组参数，可以批量删除多个打开的流   
	 * @param: @param autoCloseables      
	 * @return: void      
	 * @throws
	 */
	public static void closeAll(AutoCloseable... autoCloseables ) {
		if(autoCloseables!=null) {
			for(AutoCloseable autoCloseable:autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
     * 按行读取文件
     */
    public static List<String> ReadFileByLineOfList(String filename) {
    	List<String> arrayList = new ArrayList<>();
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
            	arrayList.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bufferedReader)
                    bufferedReader.close();
                if (null != reader)
                    reader.close();
                if (null != is)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return arrayList;
    }
	
	/**
	 * @Title: readTextFile   
	 * @Description: 以流的方式，读取文本文件内容   
	 * @param: @param file
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String readTextFile(File file) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			byte[] b = new byte[1024];
			String str = "";
			while (inputStream.read(b)!=-1) {
				str += new String(b);
			}
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			closeAll(inputStream);
		}
	}
	/**
	 * @Title: getFileContent   
	 * @Description: 根据文件全名读取文件内容   
	 * @param: @param fileFullName
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String readTextFile(String fileFullName) {
		return readTextFile(new File(fileFullName));
	}
	
	public static void writeTextFile(String content,File file,boolean append) {
		BufferedWriter writer = null;
		try {
			//判断写文件的文件夹是否存在
			String parent = file.getParent();
			File parentFile = new File(parent);
			if(!parentFile.exists()) {
				parentFile.mkdirs();
			}
			//写文件
			writer = new BufferedWriter(new FileWriter(file,append));
			writer.write(content);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			closeAll(writer);
		}
	}
	
	/**
	 * @Title: readTextFileOfList   
	 * @Description: 按行读取文件内容到list集合   
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
			String line="";
			while((line=br.readLine())!=null) {
				strList.add(line);
			}
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
	
	public static void writeTextFile(String content,String fileFullName,boolean append) {
		writeTextFile(content,new File(fileFullName), append);
	}

	public static void main(String[] args) {
		String readTextFile = readTextFile("C:\\Users\\Administrator\\Desktop\\pom.xml");
		writeTextFile(readTextFile, "C:\\Users\\Administrator\\Desktop\\aa\\aa.xml",false);
	}
}
