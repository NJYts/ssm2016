package exerciseGoWork.shufa;

import org.junit.Test;

import java.util.Random;

public class quickSortTest {
    int a[] = new int[101],n;//定义全局变量，这两个变量需要在子函数中使用
    void quicksort(int left,int right){
        int i,j,t,temp;
        if(left>right)
            return;
        temp=a[left]; //temp中存的就是基准数
        i=left;
        j=right;
        while(i!=j)
        {
        //顺序很重要，要先从右往左找,找到小于基准点的
            while(a[j]>=temp && i<j)
                j--;
        //再从左往右找，找到大于基准点的
            while(a[i]<=temp && i<j)
                i++;
        //交换两个数在数组中的位置
            if(i<j)//当哨兵i和哨兵j没有相遇时
            {
                t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }
        //设置新的基准数
        a[left]=a[i];
        //基准数归位
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
