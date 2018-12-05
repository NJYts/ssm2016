package exerciseGoWork.shufa;

import java.util.Arrays;

/**
 *
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 *
 * @Auther: niujianye
 * @Date: 2018/11/26 14:31
 * @Description:
 * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略
 * （分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 *
 * 归并排序是稳定排序，它也是一种十分高效的排序，能利用完全二叉树特性的排序一般性能都不会太差。
 * java中Arrays.sort()采用了一种名为TimSort的排序算法，就是归并排序的优化版本。
 * 从上文的图中可看出，每次合并操作的平均时间复杂度为O(n)，而完全二叉树的深度为|log2n|。
 * 总的平均时间复杂度为O(nlogn)。而且，归并排序的最好，最坏，平均时间复杂度均为O(nlogn)。
 *
 *
 */
public class MergeSort {
    public static void main(String []args){
        int []arr = {9,2,6,5};
        sort1(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
            System.out.println(Arrays.toString(arr));
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        System.out.println("左序列指针:"+i+" 右序列指针:"+j);
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }

        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
    public static void sort1(int []arr){
        int []temp = new int[arr.length];
        sort1(arr,0,arr.length-1,temp);

    }

    private static void sort1(int[] arr,int left,int right,int []temp){

        if (left<right) {
            int mid = (left+right)/2;
            sort1(arr, left, mid, temp);
            sort1(arr, mid+1, right, temp);
            merge1(arr,left,mid,right,temp);//将两个有序子数组合并操作
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void merge1(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;int j=mid+1;
        System.out.println("i左侧序列指针："+i+" j右侧序列指针："+j);
        int t = 0;
        while (i<=mid&&j<=right) {
            if (arr[i]>arr[j]) {
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

}
