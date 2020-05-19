package com.adobe.program.leetcode;

public class BinaryTreeMaximumPathSum {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        
    }

    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getLeftRightSum(root);
        return sum;
    }

    public int getLeftRightSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = Math.max(getLeftRightSum(node.left), 0);
        int rightSum = Math.max(getLeftRightSum(node.right), 0);
        sum = Math.max(sum, node.val + leftSum + rightSum);

        return node.val + Math.max(leftSum, rightSum);
    }
}
