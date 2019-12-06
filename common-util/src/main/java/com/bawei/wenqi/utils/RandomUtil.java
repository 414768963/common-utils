/** 
 * @Title: RandomUtil.java 
 * @Package com.bawei.wenqi.utils 
 * @Description: TODO(��һ�仰�������ļ���ʲô) 
 * @author ���� 
 * @date 2019��12��6�� 
 * @version V1.0 
 */ 

package com.bawei.wenqi.utils;

import java.util.Random;

/** 
 * @Title: RandomUtil.java 
 * @Package com.bawei.wenqi.utils 
 * @Description: ���������
 * @author ���� 
 * @date 2019��12��6�� 
 * @version V1.0 
 */

public class RandomUtil {
	/**
	 * @Title: random   
	 * @Description: �����С���������֮��������   
	 * @param: @param min
	 * @param: @param max
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int random(int min,int max) {
		Random random = new Random();
		return min+random.nextInt(max-min+1);
	}
	/**
	 * @Title: random   
	 * @Description: �����С���������֮��Ķ�������
	 * @param: @param min
	 * @param: @param max
	 * @param: @param num
	 * @param: @return      
	 * @return: int[]      
	 * @throws
	 */
	public static int[] random(int min,int max,int num) {
		int[] intArray = new int[num];
		for (int i = 0; i < num; i++) {
			intArray[i] = random(min, max);
		}
		return intArray;
	}
	
	public static void main(String[] args) {
		int[] random = random(10, 15,100);
		for (int i : random) {
			System.out.println(i);
		}
	}
}
