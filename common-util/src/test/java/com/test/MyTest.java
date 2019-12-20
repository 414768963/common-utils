/** 
 * @Title: MyTest.java 
 * @Package com.test 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 文琪 
 * @date 2019年12月20日 
 * @version V1.0 
 */ 

package com.test;

import java.util.List;

import org.junit.Test;

import com.bawei.wenqi.utils.StreamUtil;

/** 
 * @Title: MyTest.java 
 * @Package com.test 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 文琪 
 * @date 2019年12月20日 
 * @version V1.0 
 */

public class MyTest {

	@Test
	public void TestList() {
		List<String> a = StreamUtil.ReadFileByLineOfList("C:\\Users\\文琪\\Desktop\\abc.txt");
		for (String string : a) {
			System.out.println(string);
		}
	}
}
