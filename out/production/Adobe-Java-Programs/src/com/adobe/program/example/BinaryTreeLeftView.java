package com.adobe.program.example;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreeLeftView {
    static BTree root;

    static class BTree {
        int data;
        BTree left;
        BTree right;

        public BTree(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(BTree node, int data) {
        if (node == null) {
            root = new BTree(data);
            return;
        }
        if (data < node.data) {
            if (node.left == null) {
                node.left = new BTree(data);
            } else {
                insert(node.left, data);
            }
        } else if (data > node.data) {
            if (node.right == null) {
                node.right = new BTree(data);
            } else {
                insert(node.right, data);
            }
        }
    }

    public void print(BTree node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " -> ");
        print(node.left);
        print(node.right);
    }

    public void preOrder(BTree node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " -> ");
        print(node.left);
        print(node.right);
    }

    public void inOrder(BTree node) {
        if (node == null) {
            return;
        }
        print(node.left);
        System.out.print(node.data + " -> ");
        print(node.right);
    }

    public void postOrder(BTree node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " -> ");
        print(node.left);
        print(node.right);
    }

    public void printLeftView(BTree root) {
        AtomicInteger lastLevel = new AtomicInteger(0);
        leftView(root, 1, lastLevel);
    }

    public static void leftView(BTree root, int level, AtomicInteger lastLevel) {
        if (root == null) {
            return;
        }
        if (lastLevel.get() < level) {
            System.out.print(root.data + " ");
            lastLevel.set(level);
        }
        leftView(root.left, level + 1, lastLevel);
        leftView(root.right, level + 1, lastLevel);
    }

    public static void main(String[] args) {
        BinaryTreeLeftView binaryTreeLeftView = new BinaryTreeLeftView();
        Arrays.asList(4, 1, 7, 6, 9, 5).stream().forEach(element -> binaryTreeLeftView.insert(root, element));

        binaryTreeLeftView.print(root);
        System.out.println("\nLeft View: ");
        binaryTreeLeftView.printLeftView(root);

        // BTree ordering
        System.out.println("\nBTree Ordering ");
        binaryTreeLeftView.preOrder(root);
        System.out.println();
        binaryTreeLeftView.inOrder(root);
        System.out.println();
        binaryTreeLeftView.postOrder(root);
    }
}
