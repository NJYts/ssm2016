package com.atguigu.p2p.test.shufa.fivesearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: niujianye
 * @Date: 2018/11/27 10:04
 * @Description:
 * 解决hash冲突 https://www.cnblogs.com/zhangbing12304/p/7997980.html
 * 1 开放定址法   2 再哈希法   3 链地址法   4 建立公共溢出区
 *
 * 给定表M，存在函数f(key)，对于任意关键字值key，代入函数后若能得到该关键字记录在表中的地址，
 * 则称表M为哈希(Hash）表，函数f(key)为哈希(Hash) 函数；
 * 更通俗来说，哈希表通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。
 * 这里用 除留余数法（余数大于等于0小于除数）来构造哈希表 和 开放定址法中的线性探测再散列 来处理不同关键字通过哈希函数映射到同一地址的冲突。
    1、除留余数法：取关键字被某个不大于散列表表长m的数p除后所得的余数为散列地址。即 H(key) = key MOD p,p<=m。
    2、线性探测再散列：Hi=(H(key) + di) MOD m,i=1,2，…，k(k<=m-1），其中H(key）为散列函数，m为散列表长，di=1,2,3，…，m-1

   哈希表也称散列表，查找有两种方式，比较式查找和计算式查找，而计算式查找则通过哈希表来实现。
 */
public class HashTable {

    static int key[]={4,7,29,19,16,22,92,3,8,22};
    static int N=key.length;	//散列表长度
    static int ht[]=new int[N];
    public static void main(String[] args) {
        System.out.println();
        System.out.print("原数组:	"+Arrays.toString(key));

        for (int i = 0; i < ht.length; i++) {
            ht[i]=-1;	//初始化，可根据实际情况初始化
        }
        System.out.println();

        for (int i = 0; i < key.length; i++) {
            hashSearch1(ht,key[i]);
        }

        System.out.println();
        System.out.print("关键码:	");
        for (int i = 0; i < ht.length; i++) {
            System.out.print(ht[i]+"	");
        }

        System.out.println();
        System.out.print("hashtable 循环检索原数组，返回下标:	");
        for (int i = 0; i < key.length; i++) {
            System.out.print(hashSearch1(ht,key[i])+"	");
        }

        System.out.println();
        System.out.print("关键码:	"+Arrays.toString(ht));

        System.out.println();
        while (true) {
            // 哈希表查找
            System.out.print("请输入要查找的数据：");
            int data = new Scanner(System.in).nextInt();
            int result = hashSearch1(ht, data);
            if (result == -1) {
                System.out.println("对不起，没有找到！");
            } else {
                System.out.println("数据的位置是：" + result);
            }
        }
    }

    static int hashSearch1(int ht[],int k){
        int j=h(k);
        //该位置存在
        if (ht[j] == k) {
            return j;
        }
        //该位置为空
        if (ht[j]==-1){
            ht[j]=k;
            return j;
        }
        //该位置被占用 再+1取余数
        int i=(j+1)%N;
        //循环遍历散列表
        while (i!=j) {
            //当再次之后位置不为空且与原位置不重复时
            if(ht[i]==k)
                return i;
            if(ht[i]==-1){
                ht[i]=k;
                return i;
            }
            i=(++i)%N;
        }
        System.err.println("哈希表溢出！");
        return -1;
    }


    //散列表下标
    static int h(int v){
        return v%N;
    }

    static int hashSearch(int ht[],int len,int k){
        int j=h(k);
        if (ht[j]==k) {//查找成功
            return j;
        }else if(ht[j]==-1){//该位置为空，插入，返回
            ht[j]=k;
            return j;
        }
        int i=(j+1)%N;
        while (ht[i]!=-1&&i!=j) {//循环遍历散列表
            if(ht[i]==k){
                return i;
            }else {
                i=(++i)%N;
            }
        }
        if (i==j) {//遍历散列表一遍，没找到，满
            System.err.println("哈希表溢出！");
        }else {
            ht[i]=k;
            return i;
        }
        return 0;
    }


}
