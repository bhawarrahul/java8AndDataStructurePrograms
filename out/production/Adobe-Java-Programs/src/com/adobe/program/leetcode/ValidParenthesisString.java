package com.adobe.program.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {
        String s = "(*)";
        System.out.println("Result: " + new ValidParenthesisString().checkValidString(s));

    }

    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }

}
