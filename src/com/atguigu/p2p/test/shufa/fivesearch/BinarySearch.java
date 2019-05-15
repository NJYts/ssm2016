package com.atguigu.p2p.test.shufa.fivesearch;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.print("二分查找的结果是：");
        int[] n = { 11, 22, 33, 44, 55, 66, 77, 88, 99 };
        System.out.println("66下标是" + SecondChaZhao(n, 66));
    }

    /**
     * 二分法查找，前提：被查找的数组是有序排列的，没有该数，默认返回-1
     * @param m 被查找的数组数据
     * @param key 需要查找的数据
     *
     */
    public static int SecondChaZhao(int[] m, int key) {
        int min=0;int max=m.length;int mid=0;
        while (min <= max) {
            mid = (min + max)/2;
            if (m[mid] < key){
                min = mid+1;
            }else if (m[mid] > key){
                max = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
