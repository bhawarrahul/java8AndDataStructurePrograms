package com.adobe.program.example;

public class FibonacciSeries {
    public static void main(String[] args) {
        printFibonacci(10);
    }

    private static void printFibonacci(final int number) {
        int n1 = 0, n2 = 1;
        System.out.print(n1 + " " + n2 + " ");
        for (int i = 2; i < number; i++) {
            final int n3 = n1 + n2;
            System.out.print(n3 + " ");
            n1 = n2;
            n2 = n3;
        }
    }
}
