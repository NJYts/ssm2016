package com.atguigu.p2p.test.exercise;

/**
 * Created by WISE on 2018/2/2.
 */
public class Exercise {
	public static void main(String[] args) {
		int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
		arr = selectSort(arr);
		for(int i = 0;i < arr.length;i++){
			System.out.println(arr[i] + " ");
		}
	}
	public static int[] selectSort(int[] arr){
		for(int i = 0;i < arr.length -1;i++){
			int min = i;
			for(int j = i+1;j < arr.length;j++){
				if(arr[min] > arr[j]){
					min = j;
				}
			}
			if(min != i){
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}

		}
		return arr;

	}

}
