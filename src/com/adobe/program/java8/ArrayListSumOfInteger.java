package com.adobe.program.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayListSumOfInteger {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Map<Integer, Integer> map = list
                .stream()
                .distinct()
                .collect(Collectors.toMap(el-> el, el-> el));
        System.out.println(list);
        System.out.println(map);

        int sum = list.stream().reduce(0, Integer::sum);
        System.out.println("List 1 to 10 sum : " + sum);

        sum = list.stream().mapToInt(el-> el).sum();
        System.out.println("List 1 to 10 sum : " + sum);

        sum = map.keySet().stream().reduce(0, Integer::sum);
        System.out.println("Map 1 to 10 sum : " + sum);

        sum = map.values().stream().reduce(0, (sum1, value)-> (sum1 + value));
        System.out.println("Map 2 to 10 sum : " + sum);

    }
}
