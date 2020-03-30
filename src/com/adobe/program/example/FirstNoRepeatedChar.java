package com.adobe.program.example;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FirstNoRepeatedChar {
    public static void main(String[] args) {
        String str = "zzzzzbbbcccaacddfehhhhiii";
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                int details = map.get(ch) + 1;
                map.put(ch, details);
            } else {
                map.put(ch, 1);
            }
        }
        System.out.println(map);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(" First Non Repeated Char: " + entry.getKey());
                break;
            }
        }

        // using group by
        Map<String, Long> map2 = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
        System.out.println(map2);
        for (Map.Entry<String, Long> entry : map2.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("1 First Non Repeated Char: " + entry.getKey());
                break;
            }
        }

    }
}
