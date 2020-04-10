package com.adobe.program.leetcode;


class LinkedListExample {
    ListNode head;

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void insert(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void print() {
        ListNode temp = head;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class MiddleOfTheLinkedList {


    public static void main(String[] args) {
        LinkedListExample example = new LinkedListExample();
        int[] array = {1, 2, 3, 4, 5};
        for (int i = 0; i < array.length; i++) {
            example.insert(array[i]);
        }
        example.print();
        System.out.println("Middle Element: " + example.middleNode(example.head).val);
    }
}
