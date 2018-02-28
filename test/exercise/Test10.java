package exercise;

import org.junit.Test;

public class Test10 {
	/*
	 * 在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。
	 * 强转
	 * 1. 父类转化为子类时需要。
		A extend B.

		那么：B = A（子类赋值给父类，不需要）
		  A = (A)B 此时需要

		2. 基本数据的长数据变为短数据类型时。
		char -> byte -> short -> int   -> long 此顺序不需要强转，相反则需要。
	 *
	 *
	 */
	@Test
	public void test10(){
		String str = "abaccdeff";
		int[] arr = new int[256];
		for(int i = 0;i < str.length();i++){
			arr[str.charAt(i)]++;
			System.out.println(str.charAt(i)+"    "+arr[str.charAt(i)]);
		}
		System.out.println();
		for(int i = 0;i < str.length();i++){
			if(arr[str.charAt(i)] == 1){
				System.out.println(str.charAt(i));
				break;
			}
		}
	}

	public static void main(String[] args) {
		String str = "abaccdeff";
		System.out.println((int)str.charAt(0));
	}
}
