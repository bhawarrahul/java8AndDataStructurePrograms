package com.adobe.program.leetcode;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
//        int[] array = {0, 1, 0, 3, 12};
        int[] array = {0, 0, 1};
        new MoveZeroes().moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }

    public void moveZeroes(int[] nums) {
        int lastIndex = nums.length;
        for (int index = 0; index < lastIndex; index++) {
            if (nums[index] == 0) {
                int temp = nums[index];
                for (int i = index; i < nums.length - 1; i++) {
                    nums[i] = nums[i + 1];
                }
                nums[nums.length - 1] = temp;
                if (nums[index] == 0) {
                    index--;
                }
                lastIndex--;
            }
        }
    }
}
