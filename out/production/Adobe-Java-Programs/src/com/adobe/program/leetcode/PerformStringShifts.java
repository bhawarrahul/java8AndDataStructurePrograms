package com.adobe.program.leetcode;

import java.util.Arrays;

public class PerformStringShifts {
    public static void main(String[] args) {
        int[][] shift = {{1, 1}, {1, 1}, {0, 2}, {1, 3}};
        String s = "abcdefg";
        System.out.println(new PerformStringShifts().stringShift(s, shift));
    }

    public String stringShift(String s, int[][] shift) {
        char[] array = s.toCharArray();
        int leftCount = 0;
        for (int i = 0; i < shift.length; i++) {
            int[] shiftValue = shift[i];
            if (shiftValue[0] == 0) {
                leftCount -= shiftValue[1];
            } else {
                leftCount += shiftValue[1];
            }
        }
        if (leftCount < 0) {
            leftCount = -leftCount;
            array = leftRotateArray(array, leftCount);
        } else {
            array = rightRotateArray(array, leftCount);
        }
        return new String(array);
    }

    public char[] leftRotateArray(char arr[], int d) {
        for (int i = 0; i < d; i++) {
            char temp;
            temp = arr[0];
            int j;
            for (j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = temp;
        }
        return arr;
    }

    public char[] rightRotateArray(char arr[], int d) {
        for (int i = 0; i < d; i++) {
            char temp = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
        return arr;
    }
}
