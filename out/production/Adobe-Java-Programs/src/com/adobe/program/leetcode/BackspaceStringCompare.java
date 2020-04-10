package com.adobe.program.leetcode;

import java.util.regex.Pattern;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        String S = "ab##", T = "c#d#";
        System.out.println("Result: " + new BackspaceStringCompare().backspaceCompare(S, T));
    }

    public boolean backspaceCompare(String S, String T) {
        if (!(S.length() >= 1 && S.length() <= 200) || !(T.length() >= 1 && T.length() <= 200)) {
            return false;
        }
        if (!((S.equals(S.toLowerCase())) && (T.equals(T.toLowerCase())))) {
            return false;
        }
        return removedString(S).equals(removedString(T));
    }

    private static String removedString(String str) {
        int n = str.length(), count = 0;
        String resultString = "";
        for (int index = n - 1; index >= 0; index--) {
            char ch = str.charAt(index);
            if (ch == '#') {
                count++;
            } else {
                if (count > 0)
                    count--;
                else {
                    resultString += ch;
                }
            }
        }
        return resultString;
    }
}
