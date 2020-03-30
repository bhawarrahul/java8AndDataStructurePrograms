package com.adobe.program.java8;

import java.util.Arrays;
import java.util.List;

public class SumOfEvenOddNumber {
    public static void main(String[] args) {
        printEvenNumberSum();
        printOddNumberSum();
        System.out.println("Total - " + (10 * (10 + 1) / 2));
    }

    private static void printEvenNumberSum() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = list.stream().filter(number -> number % 2 == 0).reduce(0, Integer::sum);
        System.out.println("Even Sum: " + sum);
    }

    private static void printOddNumberSum() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = list.stream().filter(number -> number % 2 != 0).reduce(0, Integer::sum);
        System.out.println("Odd Sum: " + sum);
    }
}
