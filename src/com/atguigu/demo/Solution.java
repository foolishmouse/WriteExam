package com.atguigu.demo;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(10);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        t5.right = t6;

        System.out.println(height(t1));
    }

    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }else {
            return Math.max(height(root.left),height(root.right))+1;
        }
    }

}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
