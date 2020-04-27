package com.adobe.program.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] array = {0, 1, 0, 0, 1, 1, 0};
        System.out.println("Result : " + new ContiguousArray().findMaxLength(array));
    }

    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, -1);
        int subArray = 0;
        int count = 0;
        for (int index = 0; index < nums.length; index++) {
            count = count + (nums[index] == 1 ? 1 : -1);
            if (countMap.containsKey(count)) {
                subArray = Math.max(subArray, index - countMap.get(count));
            } else {
                countMap.put(count, index);
            }
        }
        return subArray;
    }
}
