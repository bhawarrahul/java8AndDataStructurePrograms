package com.adobe.program.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class FirstNonRepeatedChar {
    public static void main(String[] args) {
        String str = "zzzzzbbbcccaacddehhhhiii";
        String removeStr = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String subStr = removeStr + str.substring(i + 1, str.length() - 1);
            if (subStr.indexOf(ch) == -1) {
                System.out.println("First Char : " + ch);
                break;
            } else {
                removeStr = removeStr + ch;
            }
        }
        print(str);
        print2(str);
    }

    public static void print(String s) {
        for (Character ch : s.toCharArray()) {
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                System.out.println("First non repeat character = " + ch);
                break;
            }
        }
    }

    public static void print2(String s) {
        Set<Character> valid = new HashSet<>();
        Set<Character> invalid = new HashSet<>();
        for (Character ch : s.toCharArray()) {
            if (valid.contains(ch)) {
                valid.remove(ch);
                invalid.add(ch);
            } else if(!invalid.contains(ch) && !valid.contains(ch)) {
                valid.add(ch);
            }
        }
        System.out.println("First:" + valid.iterator().next());
    }
}
