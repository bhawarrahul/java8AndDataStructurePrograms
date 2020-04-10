package com.adobe.program.leetcodestudy;

import java.util.Arrays;

public class StringReverseUsingRecursion {
    public static void main(String[] args) {
        final String str = "Rahul Ankush Bhawar";
        reverse(0, str);
        new StringReverseUsingRecursion().reverseString(str.toCharArray());
    }

    private static void reverse(int index, String string) {
        if (string == null || index >= string.length()) {
            return;
        }
        reverse(index + 1, string);
        System.out.print(string.charAt(index));
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char ch = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = ch;
        }
        System.out.println(Arrays.toString(s));
    }

}
