package exerciseGoWork.shufa;

import java.util.ArrayList;

/**
 * Created by njy on 2018/10/31.
 * 交换排序（冒泡排序、快速排序 O(N*log2 N) ）、选择排序（直接选择排序、堆排序）、插入排序（直接插入排序、希尔排序）
 * 归并排序、顺序查找、二分查找、哈希查找
 */
public class ExerciseAll {
    private static int a[] = new int[] { 2, 5, 1, 4, 6, 8, 7, 9, 8 , 22 , 3 , 10},na;//定义全局变量，这两个变量需要在子函数中使用
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        int a1 =1; int b = 1;
        System.out.println(a1==b);
        // 冒泡排序 - begin...
        int[] m = new int[] { 2, 5, 1, 4, 6, 8, 7, 9, 8 , 22 , 3 , 10};
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

        System.out.print("二分查找的结果是：");
        int[] n = { 11, 22, 33, 44, 55, 66, 77, 88, 99 };
        System.out.println("66下标是" + SecondChaZhao(n, 66));

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
     * 冒泡排序：下标相邻的两个数进行比较交换
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
         它的基本思想是：通过一轮排序以第一个数为基准值，将要排序的数据分割交换成独立的两部分，
         其中一部分的所有数据都比另外一部分的所有数据都要小，将基准值与两部分中间相遇位置的值互换，确定基准值的顺序位置。
         然后再按此方法对这两部分数据分别进行快速排序，
         整个排序过程递归进行，以此达到整个数据变成有序序列。
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
     * 选择排序：依次固定每个下标，让每个固定下标中的数和后面所有的数据进行比较 选择出最大或者最小的值
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
