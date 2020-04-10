package com.adobe.program.sorting;

import java.util.Arrays;

public class QuickSort {
    static int array[] = {12, 11, 13, 5, 6, 7};

    public static void main(String[] args) {

        quickSort(0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int low, int high) {
        int i = low;
        int j = high;
        int pivot = array[low + (high - low) / 2];
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(low, j);
        if (i < high)
            quickSort(i, high);
    }
}
