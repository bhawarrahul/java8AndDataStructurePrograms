package com.adobe.program.java8;

import java.util.stream.IntStream;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(" 5  Is prime: " + isPrimeNumber(5));
        System.out.println(" 6  Is prime: " + isPrimeNumber(6));
    }

    private static boolean isPrimeNumber(int number) {
        return number > 1 && IntStream.range(2, number).noneMatch(num -> number % num == 0);
    }
}
