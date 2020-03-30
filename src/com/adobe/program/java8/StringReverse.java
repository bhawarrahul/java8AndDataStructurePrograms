package com.adobe.program.java8;

import java.util.stream.IntStream;

public class StringReverse {
    public static void main(String[] args) {
        String[] string = "Hello world".split(" ");
        IntStream.range(0, string.length).mapToObj(index -> string[string.length - 1 - index])
                .forEach(str -> System.out.print(str + " "));
    }
}
