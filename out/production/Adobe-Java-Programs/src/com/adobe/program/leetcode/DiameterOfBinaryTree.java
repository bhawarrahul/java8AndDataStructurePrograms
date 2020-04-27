package com.adobe.program.leetcode;

import com.adobe.program.example.BinaryTreeLeftView;

import java.util.Arrays;

class BT {
    static TreeNode root;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void insert(TreeNode node, int data) {
        if (node == null) {
            root = new TreeNode(data);
            return;
        }
        if (data < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(data);
            } else {
                insert(node.left, data);
            }
        } else if (data > node.val) {
            if (node.right == null) {
                node.right = new TreeNode(data);
            } else {
                insert(node.right, data);
            }
        }
    }

    public void print(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " -> ");
        print(node.left);
        print(node.right);
    }
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root!=null && root.left == null && root.right==null) {
            return 0;
        }
        getHeight(root);
        return diameter ;
    }
    private int getHeight(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return Math.max(leftHeight , rightHeight) + 1;
    }
}

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        BT bt = new BT();
        Arrays.asList(1, 2, 3, 4, 5).stream().forEach(element -> bt.insert(bt.root, element));
        bt.print(bt.root);
        System.out.println("\nDiameter: " + bt.diameterOfBinaryTree(bt.root));
    }
}
