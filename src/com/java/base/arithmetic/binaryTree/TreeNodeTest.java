package com.java.base.arithmetic.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * mjt 梅锦涛
 * 2024/3/10
 *
 * @author mjt
 */
public class TreeNodeTest {

    int val = 0;
    TreeNodeTest left = null;
    TreeNodeTest right = null;

    public TreeNodeTest(int val) {
        this.val = val;
    }

    //TreeNodeTest(int val, TreeNode left, TreeNode right) {
    //    this.val = val;
    //    this.left = left;
    //    this.right = right;
    //}

}

class Solutions {
    List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        TreeNodeTest treeNode = new TreeNodeTest(4);
        treeNode.left = new TreeNodeTest(3  );
        treeNode.left.left = new TreeNodeTest(2);
        treeNode.left.left.left = new TreeNodeTest(1);
        treeNode.right = new TreeNodeTest(6);
        treeNode.right.left = new TreeNodeTest(5);

        Solutions solutions = new Solutions();
        int[] ints = solutions.inorderTraversal(treeNode);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

        System.out.println("长度："+solutions.maxDepth(treeNode));

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] inorderTraversal(TreeNodeTest root) {
        // write code here
        inorder(root);
        return list.stream().mapToInt(Integer::valueOf).toArray();

    }

    /**
     * 当前是 后序遍历
     *  提示：
     *      if (root == null) {
     *             return;
     *         }
     *  第一：树形结构的第一句一定是一个结束条件或返回条件。 该return，主要是为了结束递归，不然会一直递归下去。叶子节点的左右节点都是null。
     *  第二：一个最基本的树形结构，是由 跟节点、左节点、右节点组成的。
     *  第三：return是基于当前基本树形结构来进行返回。
     *      举例：TreeNodeTest treeNode = new TreeNodeTest(4);
     *         treeNode.left = new TreeNodeTest(3  );
     *         treeNode.left.left = new TreeNodeTest(2);
     *         2 的左右节点都是null，所以返回到上一个节点是3。
     *         当 3 的左、右节点运行完毕，返回到上一个节点是4。
     *
     *
     *
     * @param root
     */
    public void inorder(TreeNodeTest root) {
        if (root == null) {
            return;
        }


        inorder(root.left);
        inorder(root.right);
        list.add(root.val);
    }

    public int maxDepth(TreeNodeTest root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}