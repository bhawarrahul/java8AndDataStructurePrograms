package com.adobe.program.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        // Without Any delimiter
        System.out.println(list.stream().collect(Collectors.joining()));
        // With Delimiter
        System.out.println(list.stream().collect(Collectors.joining("--")));
        // // With Delimiter and prefix and suffix
        System.out.println(list.stream().collect(Collectors.joining("--", "[", "]")));
    }
}
