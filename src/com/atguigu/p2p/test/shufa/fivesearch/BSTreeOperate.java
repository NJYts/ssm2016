package com.atguigu.p2p.test.shufa.fivesearch;

public class BSTreeOperate {

    // 树的根节点
    public BSTreeNode root;
    // 记录树的节点个数
    public int size;

    /**
     * 创建二叉排序树
     *
     * @param list
     * @return
     */
    public BSTreeNode create(int[] list) {

        for (int i = 0; i < list.length; i++) {
            insert(list[i]);
        }
        return root;
    }

    /**
     * 插入一个值为data的节点
     *
     * @param data
     */
    public void insert(int data) {
        insert(new BSTreeNode(data));
    }

    /**
     * 插入一个节点
     *
     * @param bsTreeNode
     */
    public void insert(BSTreeNode bsTreeNode) {
        if (root == null) {
            root = bsTreeNode;
            size++;
            return;
        }
        BSTreeNode current = root;
        while (true) {
            if (bsTreeNode.data <= current.data) {
                // 如果插入节点的值小于当前节点的值，说明应该插入到当前节点左子树，而此时如果左子树为空，就直接设置当前节点的左子树为插入节点。
                if (current.left == null) {
                    current.left = bsTreeNode;
                    size++;
                    return;
                }
                current = current.left;
            } else {
                // 如果插入节点的值大于当前节点的值，说明应该插入到当前节点右子树，而此时如果右子树为空，就直接设置当前节点的右子树为插入节点。
                if (current.right == null) {
                    current.right = bsTreeNode;
                    size++;
                    return;
                }
                current = current.right;
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param bsTreeNode
     */
    public void LDR(BSTreeNode bsTreeNode) {
        if (bsTreeNode != null) {
            // 遍历左子树
            LDR(bsTreeNode.left);
            // 输出节点数据
            System.out.print(bsTreeNode.data + " ");
            // 遍历右子树
            LDR(bsTreeNode.right);
        }
    }

    /**
     * 查找节点
     */
    public boolean search(BSTreeNode bsTreeNode, int key) {
        // 遍历完没有找到，查找失败
        if (bsTreeNode == null) {
            return false;
        }
        // 要查找的元素为当前节点，查找成功
        if (key == bsTreeNode.data) {
            return true;
        }
        // 继续去当前节点的左子树中查找，否则去当前节点的右子树中查找
        if (key < bsTreeNode.data) {
            return search(bsTreeNode.left, key);
        } else {
            return search(bsTreeNode.right, key);
        }
    }
}
