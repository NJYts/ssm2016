package exerciseGoWork.shufa;

/**
 * Created by njy on 2018/10/31.
 */
public class ExerciseAll {
    private static int a[] = new int[] { 2, 5, 1, 4, 6, 8, 7, 9, 8 , 22 , 3 , 10},na;//定义全局变量，这两个变量需要在子函数中使用
    public static void main(String[] args) {
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
        /*int i,j,t;
        for(i=0;i<101;i++){
            a[i] = (int) (Math.random()*100);
        }*/
        quicksort(0,a.length-1); //快速排序调用
        //输出排序后的结果
        for(int i=1;i<a.length;i++){
            if (a[i] != a[i-1]){
                System.out.print(a[i]+" , ");
            }
        }
    }
    /**
     * 冒泡排序：下标相邻的两个数进行排序
     * @param m 需要排序的数据，按由小到大排序
     */
    public static void MaoPaoPaixu(int[] m) {

    }
    /**
     * 二分法查找，前提：被查找的数组是有序排列的，没有该数，默认返回-1
     *
     * @param m 被查找的数组数据
     * @param key 需要查找的数据
     *
     */
    public static int SecondChaZhao(int[] m, int key) {

        return -1;
    }
    /**
     * 选择排序：依次固定每个下标，让每个固定下标中的数和后面所有的数据进行比较 找出最大或者最小的值
     *
     * @param m 需要排序的数据，按大到小排序
     */
    public static void XuanzePaixu(int[] m) {

    }

    /**
     * 快速排序
     *
     *  冒泡排序的一种改进。
         它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，
         其中一部分的所有数据都比另外一部分的所有数据都要小，
         然后再按此方法对这两部分数据分别进行快速排序，
         整个排序过程可以递归进行，以此达到整个数据变成有序序列。
     * @param left
     * @param right
     */
    static void quicksort(int left,int right){
        int i =left,j=right,temp,temp2;
        if (left>=right) return;
        temp = a[left];//基准点
        while (i != j){
            //从右开始寻找小于基准点得值
            while (a[j] >= temp && i<j) j--;
            //从左侧开始寻找大于基准点的值
            while (a[i] <= temp && i<j) i++;
            if (i<j){
                temp2 = a[j];
                a[j]=a[i];
                a[i]=temp2;
            }
        }
        //置换基准点
        a[left]=a[i];
        a[i] = temp;
        //递归另两部分
        quicksort(left,i-1);
        quicksort(i+1,right);

    }
}