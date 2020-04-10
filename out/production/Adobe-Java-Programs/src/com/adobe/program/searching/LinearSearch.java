package com.adobe.program.searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = new int[]{
                7, 8, 9, 10, 45, 56, 67, 88, 99
        };
        linearSearch(array, 56);
    }

    private static void linearSearch(int[] array, int elementFind) {
        for (int i = 0; i < array.length; i++) {
            if(array[i]==elementFind) {
                System.out.println("Element Found : " + array[i] + " at Index: " + i);
                break;
            }
        }
    }
}
