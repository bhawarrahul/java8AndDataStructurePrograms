package com.adobe.program.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        selectionSort(arr);
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallNumberIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[smallNumberIndex]) {
                    smallNumberIndex = j;
                }
            }
            int temp = array[smallNumberIndex];
            array[smallNumberIndex] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
