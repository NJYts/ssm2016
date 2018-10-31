package exerciseGoWork.shufa;

import org.junit.Test;

/**
 *  冒泡排序的一种改进。
    它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，
                 其中一部分的所有数据都比另外一部分的所有数据都要小，
                 然后再按此方法对这两部分数据分别进行快速排序，
                 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 */
public class quickSortTest {
    int a[] = new int[101],n;//定义全局变量，这两个变量需要在子函数中使用
    void quicksort(int left,int right){
        int i,j,t,temp;
        if(left>right) return;
        temp=a[left]; //temp中存的就是基准数
        i=left;
        j=right;
        while(i!=j){
            //顺序很重要，先移动的永远是基准点开始的另一侧（这次就是右侧），这样可以保证每一次基准点与重逢位置的值置换后不破坏左右的分布
            //假如首先移动左侧的i 那么当左右移动相逢时 则ij会是在符合右半部分的第一个值（j的位置上）
            //假如首先移动右侧的j 那么当左右移动相逢时 则ij会是在符合左半部分的第一个值（i的位置上）
            //要先从右往左找,找到小于基准点的
            while(a[j]>=temp && i<j) j--;
            //再从左往右找，找到大于基准点的
            while(a[i]<=temp && i<j) i++;
            //当哨兵i和哨兵j没有相遇时 交换两个数在数组中的位置
            if(i<j){
                t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }
        //最后基准数归位 置换基准数
        a[left]=a[i];
        a[i]=temp;

        quicksort(left,i-1);//继续处理左边的，这里是一个递归的过程
        quicksort(i+1,right);//继续处理右边的，这里是一个递归的过程
    }
    @Test
    public void main1(){
        int i,j,t;
        for(i=0;i<101;i++){
            a[i] = (int) (Math.random()*100);
        }
        System.out.println(a.length-1);
        quicksort(1,a.length-1); //快速排序调用
        //输出排序后的结果
        for(i=1;i<a.length;i++){
            if (a[i] != a[i-1]){

                System.out.println(a[i]+" , ");
            }
        }
    }
}
