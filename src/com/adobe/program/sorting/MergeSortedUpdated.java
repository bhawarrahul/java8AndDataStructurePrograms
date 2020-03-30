package com.adobe.program.sorting;

import java.util.Arrays;

/**
 * @Author - Rahul A. Bhawar
 */
public class MergeSortedUpdated {
    public static void main(String[] args) {
        int[] array = {2, 4, 1, 5, 6, 2, 8, 7, 9};
        System.out.println("Before Sort: " + Arrays.toString(array));
        array = mergeSort(array);
        System.out.println("After Sort : " + Arrays.toString(array));
    }

    private static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int midPoint = array.length / 2;
        int[] left = new int[midPoint];
        int[] right = array.length % 2 == 0 ? new int[midPoint] : new int[midPoint + 1];

        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = array[midPoint + j];
        }
        left = mergeSort(left);
        right = mergeSort(right);
        int[] result = merge(left, right);
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }
}
