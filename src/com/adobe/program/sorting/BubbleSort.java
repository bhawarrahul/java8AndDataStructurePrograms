package com.adobe.program.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{
                1, 3, 4, 6, 2, 3, 4, 7
        };
        bubbleSort1(array);
        bubbleSort2(array);
    }

    private static void bubbleSort1(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                count++;
            }
        }
        System.out.println(count + "- > Sorted Array 1: " + Arrays.toString(array));
    }

    private static void bubbleSort2(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
                count++;
            }
            if (!swapped) {
                break;
            }
        }
        System.out.println(count + " - > Sorted Array 2: " + Arrays.toString(array));
    }
}
