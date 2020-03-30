package com.adobe.program.example;

public class StringPalindrome {
    public static void main(String[] args) {
        final String str = "abbaa";
        palindrome(str);
    }

    private static void palindrome(final String str) {
        boolean isPalindrome = true;
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println("String is Palindrome? : " + isPalindrome);
    }

}
