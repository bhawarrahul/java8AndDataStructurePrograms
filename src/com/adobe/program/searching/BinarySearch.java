package com.adobe.program.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{
                7, 8, 9, 10, 45, 56, 67, 88, 99
        };
        binarySearch(array, 99);
    }

    private static void binarySearch(int[] array, int findElement) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (array[mid] == findElement) {
                System.out.println("Element Found : " + array[mid] + " at Index: " + mid);
                break;
            }
            if (findElement > array[mid]) {
                low = mid + 1;
            } else if (findElement < array[mid]) {
                high = mid - 1;
            }
        }
    }
}
