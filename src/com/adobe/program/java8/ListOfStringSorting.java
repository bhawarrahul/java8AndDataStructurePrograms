package com.adobe.program.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListOfStringSorting {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("rahul", "bhawar", "ankush");
        System.out.println("Before sort: " + list);
        Collections.sort(list, (str1, str2) -> str1.compareTo(str2));
        System.out.println("After sort by ASCII code: " + list);

        Collections.sort(list, (str1, str2) -> str1.length() - str2.length());
        System.out.println("After sort by Length: " + list);
    }
}
