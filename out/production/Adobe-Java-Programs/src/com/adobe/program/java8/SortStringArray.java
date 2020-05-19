package com.adobe.program.java8;

import java.util.Arrays;

public class SortStringArray {
    public static void main(String[] args) {
        String[] array = {"No", "one", "could", "disentangle", "correctly"};
        Arrays.sort(array, (a, b) -> b.length() - a.length());
        System.out.println(Arrays.toString(array));
    }
}
