package com.adobe.program.example;

public class StackUsingLinkedList {
    Node top;

    static class Node {
        int data;
        Node link;

        public Node(int data) {
            this.data = data;
            link = null;
        }
    }

    public void push(int data) {
        Node temp = new Node(data);
        temp.link = top;
        top = temp;
    }

    public int pop() {
        if (top == null) return -1;

        final int data = top.data;
        top = top.link;
        return data;
    }

    public void print() {
        Node temp = top;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " - ");
            temp = temp.link;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(10);
        stack.push(50);
        stack.push(15);
        stack.push(67);
        stack.print();
        stack.pop();
        stack.print();
    }
}
