package com.adobe.program.leetcode;

import java.util.*;
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
        int[] array2 = {698,866,349,680,733,916,961,652,161,960,417,813,474,170,802,406,442,454,780,886,899,367,786,157,953,621,29,273,485,55,563,275,343,157,715,683,608,
                932,874,241,796,877,845,26,719,167,415,287,411,95,196,118,291,811,969,27,805,323,707,625,651,588,445,690,706,694,317,978,327,764,366,18,104,753,791,94,
                912,171,923,969,457,717,694,147,329,12,84,650,592,383,506,924,939,495,999,120,529,117,446,830,740,108,791,518,83,164,606,172,783,808,
                657,942,901,1000,538};
        System.out.println(new SingleNumber().singleNumber(array2));

    }
    public int singleNumber(int[] nums) {
        int number = -1;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Map<Integer, Long> map = list.stream()
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
        Map.Entry entryList = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1).findFirst().get();
        number = (int) entryList.getKey();
        return number;
    }
}
