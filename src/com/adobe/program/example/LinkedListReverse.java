package com.adobe.program.example;

public class LinkedListReverse {
    Node head;

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void insert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void print() {
        Node temp = head;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        LinkedListReverse ll = new LinkedListReverse();
        for (int count = 1; count <= 5; count++) {
            ll.insert(count);
        }
        ll.print();
        ll.reverse();
        ll.print();
    }
}
