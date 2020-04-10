package com.adobe.program.example;

public class PrintNumberUsingRecursion {
    public static void main(String[] args) {
        PrintNumberUsingRecursion recursion = new PrintNumberUsingRecursion();
        recursion.printNumber(10);
        System.out.println();
        recursion.printNumber(1, 10);
    }

    public void printNumber(int num) {
        System.out.print(num + " ");
        if (num > 1)
            printNumber(num - 1);
    }

    public void printNumber(int num, int max) {
        System.out.print(num + " ");
        if (num < max)
            printNumber(num + 1, max);

    }
}
