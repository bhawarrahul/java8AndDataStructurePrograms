package com.adobe.program.java8;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SumOfPrimeNumbers {
    public static void main(String[] args) {
        IntPredicate predicate = (num) -> {
            return IntStream.rangeClosed(2, num / 2).noneMatch(i -> num % i == 0);
        };
        int num = 40;
        int sum = 0;
        if (num >= 2) {
            sum = 2;
        }
        if (num > 2) {
            for (int i = 3; i < num; i = i + 2) {
                if(predicate.test(i)) {
                    sum +=i;
                }
            }
        }
        System.out.println("Sum : " + sum);
    }
}
