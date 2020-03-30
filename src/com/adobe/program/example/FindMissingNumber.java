package com.adobe.program.example;

import java.util.Arrays;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] array = {1, 2, 6, 5, 4, 3, 9, 7, 10};
        printMissingNumber(array, 10);
    }

    private static void printMissingNumber(int[] array, int maxNumber) {
        int total = maxNumber * (maxNumber + 1) / 2;
        System.out.println("Total : " + total);
        int sum = Arrays.stream(array).sum();
        System.out.println("Missing Number: " + (total - sum));
    }
}
