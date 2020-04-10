package com.adobe.program.leetcodestudy;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(new ReverseNumber().reverse(-123));
    }

    public int reverse(int x) {
        boolean negativeFlag = false;
        if (x < 0) {
            negativeFlag = true;
            x = -x;
        }
        int prev_rev_num = 0, rev_num = 0;
        while (x != 0) {
            int rem = x % 10;
            rev_num = (rev_num * 10) + rem;
            if ((rev_num - rem) / 10 != prev_rev_num) {
                return 0;
            }
            prev_rev_num = rev_num;
            x = x / 10;
        }
        return (negativeFlag == true) ? -rev_num : rev_num;
    }
}
