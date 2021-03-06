package com.atguigu.p2p.test.shufa.sevensort;

/**
 * Created by njy on 2018/10/31.
 * 交换排序（冒泡排序、快速排序 O(N*log2 N) ）、选择排序（直接选择排序、堆排序）、插入排序（直接插入排序、希尔排序）
 * 归并排序、顺序查找、二分查找、哈希查找
 */
public class ExerciseAll {
    private static int a[] = new int[] { 2, 5, 1, 4, 6, 8, 7, 9, 8 , 22 , 3 , 10},na;//定义全局变量，这两个变量需要在子函数中使用
    private static int[] m = new int[] { 2, 5, 1, 4, 6, 8, 7, 9, 8 , 22 , 3 , 10};
    public static void main(String[] args) {
        System.out.println("5/10="+5/10+"---5%10="+5%10);
        // 冒泡排序 - begin...
        MaoPaoPaixu(m);
        System.out.println("冒泡排序 - result...");
        for (int i:m){
            System.out.print(i+" ");
        }
        System.out.println();
        XuanzePaixu(m);
        System.out.println("选择排序 - result...");
        for (int i:m){
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println();
        System.out.println("\n快速排序 - result...");

        quicksort(0,a.length-1); //快速排序调用
        //输出排序后的结果
        for(int i=1;i<a.length;i++){
            if (a[i] != a[i-1]){
                System.out.print(a[i]+" , ");
            }
        }
    }



    /**
     * 冒泡排序：通过一个双重循环实现，每次循环中下标相邻的两个数进行比较交换，将最大值或者最小值换到循环的结尾，直到有序。
     * @param m 需要排序的数据，按由大到小排序
     */
    public static void MaoPaoPaixu(int[] m) {
        int temp = 0;
        for (int i = 0; i < m.length-1; i++) {
            for (int j = 0; j < m.length-1-i; j++) {
                if (m[j] > m[j+1]) {
                    temp=m[j];
                    m[j]=m[j+1];
                    m[j+1]=temp;
                }
            }
        }
    }

    /**
     * 快速排序 冒泡排序的一种改进。
         它的基本思想是：
         通过递归进行实现。每一轮排序以第一个数为基准值，将要排序的数据分成左右两部分，
         其中一部分的所有数据都比另外一部分的所有数据都要大，再将基准值与两部分相遇位置的值互换，
         这样就确定了基准值在数列中的最终顺序位置。然后再按此方法分别对左右两部分进行排序，
         直到待分割的数据只包含一个元素，也就是待分割的数列的左右边界相遇，来实现整个数列有序。
         从大到小
     * @param left
     * @param right
     */
    static void quicksort(int left,int right){
       int i,j,mark,temp;
       if (left >= right) return;
       i=left;j=right;
       mark=a[left];
       while (i != j){
           while (i<j && a[j] >= mark) j--;
           while (i<j && a[i] <= mark) i++;
           if (i != j) {
               temp = a[i];
               a[i] = a[j];
               a[j] = temp;
           }
       }

       a[left] = a[j];
       a[j] = mark;

        quicksort(left,i-1);
        quicksort(i+1,right);

    }



    /**
     * 选择排序：通过一个双重循环实现。依次固定每个下标，让每个固定下标上的元素和后面所有的元素进行比较，
     * 根据需求选择出最大或者最小的值，然后将固定下标上的元素与最大或者最小值互换位置。一直到固定下标移动到结尾。
     * @param m 需要排序的数据，按大到小排序
     */
    public static void XuanzePaixu(int[] m) {
        int mark;
        int temp;
        for (int i = 0; i < m.length; i++) {
            mark = i;
            for (int j = i; j < m.length; j++) {
                if (m[j] > m[mark]) mark=j;
            }
            if (mark > i) {
                temp = m[i];
                m[i] = m[mark];
                m[mark] = temp;
            }
        }
    }


}
