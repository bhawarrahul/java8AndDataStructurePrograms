package com.adobe.program.leetcode;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaximumSubArray().maxSubArray(array));
    }

    public int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        int curr_max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr_max = Math.max(nums[i], curr_max + nums[i]);
            max_sum = Math.max(max_sum, curr_max);
        }
        return max_sum;
    }
}
