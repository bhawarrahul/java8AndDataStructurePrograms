package com.adobe.program.leetcode;

import java.util.Stack;

public class MinStackExample {
    long min;
    Stack<Long> stack;

    public MinStackExample() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min); //Could be negative if min value needs to change
            if (x < min) min = x;
        }
    }

    public void pop() {
        long pop = stack.pop();
        if (pop < 0) {
            long ret = min;
            min = min - pop; //If negative, increase the min value
        }
    }

    public int top() {
        long top = stack.peek();
        if (top < 0) {
            return (int) min;
        } else {
            return (int) (top + min);
        }
    }

    public int getMin() {
        return (int) min;
    }


    public static void main(String[] args) {
        MinStackExample minStack = new MinStackExample();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> Returns -3.
        minStack.pop();
        minStack.top();      //--> Returns 0.
        System.out.println(minStack.getMin());   //--> Returns -2.
    }
}
