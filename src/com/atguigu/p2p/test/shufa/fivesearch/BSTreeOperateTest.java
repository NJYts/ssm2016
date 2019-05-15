package com.atguigu.p2p.test.shufa.fivesearch;

/**
 * 示意图 http://www.cnblogs.com/nnngu/p/8294714.html
 * 二叉排序树(Binary Sort Tree)，又称为二叉查找树(Binary Search Tree) ，即BSTree。
 * 构造一棵二叉排序树的目的，其实并不是为了排序，而是为了提高查找和插入删除的效率。
 *
 * 什么是二叉排序树呢？二叉排序树具有以下几个特点。
 * （1）若根节点有左子树，则左子树的所有节点都比根节点小。
 * （2）若根节点有右子树，则右子树的所有节点都比根节点大。
 * （3）根节点的左，右子树也分别是二叉排序树。
 */
public class BSTreeOperateTest {
    public static void main(String[] args) {
        BSTreeOperate bsTreeOperate = new BSTreeOperate();
        int[] list = new int[]{50, 30, 70, 10, 40, 90, 80};
        System.out.println("*********创建二叉排序树*********");
        BSTreeNode bsTreeNode = bsTreeOperate.create(list);
        System.out.println("中序遍历原始的数据：");
        bsTreeOperate.LDR(bsTreeNode);
        System.out.println("");
        System.out.println("");

        System.out.println("********查找节点*******");
        System.out.println("元素20是否在树中：" + bsTreeOperate.search(bsTreeNode, 20));
        System.out.println("");

        System.out.println("********插入节点*******");
        System.out.println("将元素20插入到树中");
        bsTreeOperate.insert(20);
        System.out.println("中序遍历：");
        bsTreeOperate.LDR(bsTreeNode);
        System.out.println("");
        System.out.println("");

        System.out.println("********查找节点*******");
        System.out.println("元素20是否在树中：" + bsTreeOperate.search(bsTreeNode, 20));
        System.out.println("");
    }
}
