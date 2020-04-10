package com.adobe.program.leetcodestudy;


import org.w3c.dom.NodeList;

import java.util.List;

class LinkedListClass {
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

    public ListNode swapPairs() {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = null;
        head = fast;
        while (slow != null && fast != null) {
            //swap
            ListNode temp = fast.next;
            fast.next = slow;
            slow.next = temp;
            if (prev != null) {
                prev.next = fast;
            }
            prev = slow;
            slow = temp;
            fast = slow != null ? slow.next : null;
        }
        return head;
    }

    public ListNode reverseList() {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        head = prev;
        return head;
    }
}

public class SwapNodesInPairs {
    public static void main(String[] args) {
        LinkedListClass example = new LinkedListClass();
        int[] array = {1, 2, 3, 4};
        for (int i = 0; i < array.length; i++) {
            example.insert(array[i]);
        }
        example.print();
        example.swapPairs();
        example.print();

        // Reverse
        example.reverseList();
        example.print();
    }
}
