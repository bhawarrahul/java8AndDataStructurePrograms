package com.adobe.program.example;

import java.util.Stack;

 class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack(){
        stack = new Stack<>();
    }

    public void push(int x) {  // -- 1, 2 , 1 , 3 , 1
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min); //Could be negative if min value needs to change
            if (x < min) min = x;
        }
    }
   // min = 2 ,  top = 7
    public int pop() {
//        if (stack.isEmpty()) return;

        long pop = stack.pop();

        if (pop < 0) {
            long ret = min;
            min = min - pop; //If negative, increase the min value
            return (int)ret;
        }
        return (int)(pop + min);

    }

    public int top() {
        long top = stack.peek();
        if (top < 0) {
            return (int)min;
        } else {
            return (int)(top + min);
        }
    }

    public int getMin() {
        return (int)min;
    }
}
public class MinStackExample {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(6);
        minStack.push(5);
        minStack.push(1);
        minStack.push(5);

        System.out.println("Min - " + minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println("Min - " + minStack.getMin());
    }
}
