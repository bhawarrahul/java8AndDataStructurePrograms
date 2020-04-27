package com.adobe.program.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class FindPairOfTwoNumberMatchGivenSum {
    public static void main(String[] args) {
        Integer[] input = {1, 5, 7, -1, 5};
        int sum = 6;
        IntStream.range(0, input.length)
                .forEach(i -> IntStream.range(0, input.length)
                        .filter(j -> i != j && input[i] + input[j] == sum)
                        .forEach(j -> System.out.println((input[i] + " " + input[j])))
                );
        List<Integer> list = Arrays.asList(input);
        for (int value : list) {
            int value1 = sum - value;
            if (list.contains(value1)) {
                System.out.println("val1: " + value + " val2: " + value1);
                break;
            }
        }
        list.stream().forEach(value -> {
            int value1 = sum - value;
            if (list.contains(value1)) {
                System.out.println("val11: " + value + " val22: " + value1);
            }
        });

        for (int i = 0; i < input.length; i++)
            for (int j = i + 1; j < input.length; j++)
                if ((input[i] + input[j]) == sum)
                    System.out.println("val13: " + input[i] + " val23: " + input[j]);

        getPairs(input.length, 6, input);
    // ----
//        int[] nums = {1,1,1};
//        int k = 2;
        int[] nums = {1,2,3};
        int k = 3;
        System.out.println("Count: "+ new FindPairOfTwoNumberMatchGivenSum().subarraySum(nums,k));
    }
    public int subarraySum(int[] nums, int k) {
        int count =0;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.get(k - nums[i]) != null)
                count++;
            hm.put(nums[i], k - nums[i]);
        }
        return count;
    }

    static void getPairs(int n, int sum, Integer[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hm.get(sum - arr[i]) != null)
                System.out.println("val14: " + arr[i] + " val24: " + (sum - arr[i]));
            hm.put(arr[i], sum - arr[i]);
        }
        System.out.println(hm);
    }

}
