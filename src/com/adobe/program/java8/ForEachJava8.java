package com.adobe.program.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachJava8 {
    public static void main(String[] args) {
        //List
        List<String> list = Arrays.asList("ABC","aaaa","fbfb");

        list.forEach(System.out::println);
        list.stream().forEach(System.out::println);

        //Map
        Map<String, String>  map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.forEach((key, value)-> System.out.println("Key: " + key + " value: " + value));
    }
}
