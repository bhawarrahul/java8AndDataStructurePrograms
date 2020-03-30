package com.adobe.program.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PeekMethod {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Rahul", "Bhawar", "Ankush");
        list = list.stream()
                .filter(el -> el.contains("h"))
                .peek(el -> System.out.println("Filter: " + el))
                .map(el -> el.toUpperCase())
                .peek(el -> System.out.println("After upper case: " + el))
                .collect(Collectors.toList());
        System.out.println("Final List: " + list);
    }
}
