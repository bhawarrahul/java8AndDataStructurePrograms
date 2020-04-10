package com.adobe.program.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RangeJava8 {
    static void mapToDouble() {
        IntStream.rangeClosed(0, 50)
                .mapToDouble(d -> d)
                .forEach(el-> System.out.print(el + " "));
    }

    static List<Double> mapToObj() {
        return IntStream
                .range(0, 50)
                .mapToObj(i -> new Double(i))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        mapToDouble();
        System.out.println();
        mapToObj().forEach(el-> System.out.print(el + " "));
    }
}
