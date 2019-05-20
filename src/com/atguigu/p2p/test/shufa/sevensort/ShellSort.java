package com.atguigu.p2p.test.shufa.sevensort;

import java.util.Arrays;

/**
 * @Auther: niujianye
 * @Date: 2018/11/27 14:49
 * @Description:  http://www.cnblogs.com/chengxiao/p/6104371.html
 *
 * 希尔排序是把数据按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的元素越来越多，当增量减至1时，整个序列恰被分成一组，算法便终止。
 *
 * 希尔排序是插入排序的一种，使用中对于增量序列的选择十分重要，直接影响到希尔排序的性能。
 * 我们上面选择的增量序列{n/2,(n/2)/2...1}(希尔增量)，其最坏时间复杂度依然为O(n2)，一些经过优化的增量序列如Hibbard经过复杂证明可使得最坏时间复杂度为O(n3/2)
 *
 * https://www.cnblogs.com/chengxiao/p/6103002.html 直接插入排序
 * 直接插入排序基本思想是从第二个元素开始将一个待排序的元素，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
        insertionSort2(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {1, 4, 2, 7, 9, 8, 3, 6};
        sort3(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertionSort2(int[] arr) {
        int j;
        int temp;
        for (int i = 1; i < arr.length; i++) {
            j = i;
            temp = arr[i];
            while (j-1 >0 && arr[j] > arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j]=temp;
        }
    }

    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     *
     * @param arr
     */
    public static void sort3(int[] arr) {
        for (int gap = arr.length/2; gap > 0 ; gap/=2) {
            for (int i = gap; i <arr.length ; i++) {
                int j = i;
                int temp = arr[j];
                while (j-gap>=0 && temp >arr[j-gap]) {
                    arr[j]=arr[j-gap];
                    j = j-gap;
                }
                arr[j]=temp;
            }
        }
    }

    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    //插入排序采用交换法
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     *
     * @param arr
     */
    public static void sort1(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        int j;
        for (int i = 1; i < arr.length; i++) {
            j = i;
            int temp = arr[i];
            while (j-1 >0 && arr[j] > arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j]=temp;
        }
    }

    /**
     * 交换数组元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
//        arr[a] = arr[a] + arr[b];
//        arr[b] = arr[a] - arr[b];
//        arr[a] = arr[a] - arr[b];
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
