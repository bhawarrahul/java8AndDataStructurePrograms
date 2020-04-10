package com.adobe.program.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SecondLargestNumberFromArray {
    public static void main(String[] args) {
        //method1(new int[]{3, 4, 7, 2, 5, 9, 10});
       // method2(new int[]{3, 4, 7, 2, 5, 9, 10});
        //method3(new int[]{3, 4, 7, 2, 5, 9, 10});
        method4(new int[]{3, 4, 7, 2, 5, 9, 10});
    }

    public static void method1(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    final int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Second Largest Number: " + array[array.length - 2]);
    }

    public static void method2(final int[] array) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Second Largest Number: " + array[array.length - 2]);
    }

    public static void method3(final int[] array) {
        List<Integer> list = Arrays.stream(array).mapToObj(el -> Integer.valueOf(el)).collect(Collectors.toList());
        Collections.sort(list);
        System.out.println(Arrays.toString(array));
        System.out.println("Second Largest Number: " + list.get(list.size() - 2));
    }

    public static void method4(final int[] array) {
        int second =0 ,  first = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > first) {
                second = first;
                first = array[i];
            } else if (array[i] > second && array[i] != first) {
                second = array[i];
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Second Largest Number: " + second);
    }
}
