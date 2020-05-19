package com.adobe.program.example;

public class ProductOfAllSubarrays {
    public static void main(String[] args) {
//        int arr[] = {1, 2, 3};
        int[] arr = {10, 3, 7};
        System.out.println("Sum of SubArray " +
                subArraySum(arr));
        System.out.println("Product of SubArray " +
                subArrayProduct(arr));
    }

    public static int subArraySum(int arr[]) {
        int n = arr.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += (arr[i] * (i + 1) * (n - i));
        }

        return result;
    }

    public static long subArrayProduct(int arr[]) {
        int n = arr.length;
        long result = 1;
        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                result *= arr[j];
//            }
            result = result * (long) Math.pow(arr[i], n + 1);
        }
        return result;
    }
}
