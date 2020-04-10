package com.adobe.program.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountingElements {
    public static void main(String[] args) {
//        int[] array = {1, 2, 3};
//        int[] array = {1, 1, 3, 3, 5, 5, 7, 7};
        int[] array = {1, 3, 2, 3, 5, 0};
        System.out.println(new CountingElements().countElements(array));
    }

    public int countElements(int[] arr) {
        int totalCount = 0;
        List<Integer> list = Arrays.stream(arr).mapToObj(el -> Integer.valueOf(el)).collect(Collectors.toList());
        for (int el : list) {
            if (list.contains(el + 1)) {
                totalCount++;
            }
        }
        return totalCount;
    }
}
