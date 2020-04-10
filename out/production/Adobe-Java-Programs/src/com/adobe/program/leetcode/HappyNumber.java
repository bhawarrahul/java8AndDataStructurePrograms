package com.adobe.program.leetcode;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(2));
    }

    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = getSumOfDigits(slow);
            fast = getSumOfDigits(getSumOfDigits(fast));
        }
        while (slow != fast);
        return (slow == 1);
    }

    private static int getSumOfDigits(int number) {
        return String.valueOf(number)
                .chars()
                .map(ch -> Character.getNumericValue(ch) * Character.getNumericValue(ch))
                .sum();
    }
}
