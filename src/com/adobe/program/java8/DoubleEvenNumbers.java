package com.adobe.program.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DoubleEvenNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list = list.stream().map(el -> {
            return (el % 2 == 0 ? el * 2 : el);
        }).collect(Collectors.toList());
        System.out.println(list);

        // Convert List to Array
        int[] array = list.stream().mapToInt(Integer::new).toArray();
        // Convert Array to List
        List<Integer> integerList = Arrays.stream(array).boxed().collect(Collectors.toList());

        list = IntStream.range(0, array.length).mapToObj(index -> {
            return index % 2 != 0 ? array[index] * 2 : array[index];
        }).collect(Collectors.toList());
        System.out.println(list);
    }

}
