package com.adobe.program.leetcodestudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        System.out.println("Final Row: " + pascalsTriangle.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        rowIndex = rowIndex + 1;
        int[][] arr = new int[rowIndex][rowIndex];
        List<Integer> list = new ArrayList<>();
        for (int line = 0; line < rowIndex; line++) {
            for (int i = 0; i <= line; i++) {
                if (line == i || i == 0)
                    arr[line][i] = 1;
                else {
                    arr[line][i] = arr[line - 1][i - 1] + arr[line - 1][i];
                }
                if (line == rowIndex - 1) {
                    list.add(arr[line][i]);
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
        return list;
    }
}
