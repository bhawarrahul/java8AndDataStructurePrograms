package com.adobe.program.example;

public class StringValueChange {

    public static void main(String... doYourBest) {
        String name = "aa";
        changeToHomer(name);
        System.out.println(name);
    }

    static void changeToHomer(String name) {
        name = "Homer";
    }
}
