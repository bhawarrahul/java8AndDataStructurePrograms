package com.adobe.program.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxSumFromArrayElementWithDigits {
    public static void main(String[] args) {
        int[] array = {0, 1, 96, 23};
        method2(array);
        method1(array);
    }

    private static void method1(int[] array) {
        String strConcat = Arrays.stream(array)
                .mapToObj(el -> String.valueOf(el))
                .reduce((str1, str2) -> str1.concat(str2))
                .get();
        Arrays.stream(strConcat.split(""))
                .sorted((el1, el2) -> Integer.valueOf(el2) - Integer.valueOf(el1))
                .forEach(System.out::print);
    }

    private static void method2(int[] array) {
        // 963210
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, array.length).forEach(el -> {
            int number = array[el];
            if (number == 0) list.add(0);
            while (number > 0) {
                list.add(number % 10);
                number = number / 10;
            }
        });
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining("")));
    }
}
