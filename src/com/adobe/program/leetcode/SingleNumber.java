package com.adobe.program.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] array = {2, 2, 1};
        System.out.println(new SingleNumber().singleNumber(array));
        int[] array2 = {4, 1, 2, 1, 2};
        System.out.println(new SingleNumber().singleNumber(array2));

    }
    public int singleNumber(int[] nums) {
        int number = -1;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Map<Integer, Long> map = list.stream()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Map.Entry entryList = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1).findFirst().get();
        number = (int) entryList.getKey();
        return number;
    }
}
