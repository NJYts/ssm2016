package com.atguigu.p2p.test.shufa.fivesearch;

public class BSTreeNode {
    public int data;
    public BSTreeNode left;
    public BSTreeNode right;

    public BSTreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BSTreeNode getLeft() {
        return left;
    }

    public void setLeft(BSTreeNode left) {
        this.left = left;
    }

    public BSTreeNode getRight() {
        return right;
    }

    public void setRight(BSTreeNode right) {
        this.right = right;
    }
}
