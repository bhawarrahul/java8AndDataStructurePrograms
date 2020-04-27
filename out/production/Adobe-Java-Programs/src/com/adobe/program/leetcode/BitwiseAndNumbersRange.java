package com.adobe.program.leetcode;

public class BitwiseAndNumbersRange {
    public static void main(String[] args) {
        int m = 5;
        int n = 7;
        System.out.println("Result: " + new BitwiseAndNumbersRange().rangeBitwiseAnd(m,n));
    }
    public int rangeBitwiseAnd(int m, int n) {
        if(!(m >=0 && m <= n && n <= 2147483647)) {
            return 0;
        }
        int i = 0;
        for (; m != n; ++i) {
            m >>= 1;
            n >>= 1;
        }
        return n << i;
    }
}
