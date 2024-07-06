package com.java.base.arithmetic.binaryTree;

import java.util.ArrayList;

/**
 * mjt 梅锦涛
 * 2024/3/7
 *
 * @author mjt
 */
public class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
     this.val = val;
   }

   TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
   }

    public int[] inorderTraversal (TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        inorder(root,res);
        int i=0;
        int result[] = new int[res.size()];
        for(int a:res){
            result[i++]=a;
        }
        return result;
        // write code here
    }
    public void inorder(TreeNode root,ArrayList<Integer> res){
        if(root==null) return;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.inorderTraversal(treeNode);

    }

}
