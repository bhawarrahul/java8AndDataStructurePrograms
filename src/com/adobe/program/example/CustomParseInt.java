package com.adobe.program.example;

public class CustomParseInt {
    public static void main(String[] args) {
        final int value = customParseInt("45623");
        System.out.println("Converted Value: " + value);
    }

    private static int customParseInt(final String value) {
        int sum = 0;
        final int zero = '0';
        char[] chars = value.toCharArray();
        for (char ch : chars) {
            final int chTemp = (int) ch;
            sum = (sum * 10) + (chTemp - zero);
        }
        return sum;
    }
}
