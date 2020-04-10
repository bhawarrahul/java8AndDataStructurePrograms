package com.adobe.program.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombineTwoList {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(2, 3, 1, 6, 5, 4, 3);
        List<Integer> list2 = Arrays.asList(6, 5, 4, 3, 4, 1, 8, 9);
        // Adding All collection
        List<Integer> list3 = new ArrayList<>(list1);
        list3.addAll(list2);
        System.out.println(list3.stream()
                .sorted((el1, el2) -> el2 - el1)
                .collect(Collectors.toList()));
        // Java 8
        list1 = Stream.of(list1, list2)
                .flatMap(x -> x.stream())
                .sorted((el1, el2) -> el2 - el1)
                .collect(Collectors.toList());
        System.out.println(list1);
    }
}
