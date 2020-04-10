package com.adobe.program.java8;

@FunctionalInterface
interface Functional {
    void addition(int a, int b);

    //void substraction(int a, int b);  cant use multiple abstract method if functional interface
    default void defMethod() {
        System.out.println("Default Method called");
    }
}

interface Fun {
    void addition(int a, int b);

    //    void sub(int a, int b); // method name different but same params with type not working for lambda
    default void defMethod() {
        System.out.println("Default Method called");
    }
}

public class FunctionalIntExample {
    public static void main(String[] args) {
        Functional functional = (a, b) -> {
            System.out.println("Addition is: " + (a + b));
        };
        functional.addition(10, 20);
        functional.addition(30, 40);
        functional.defMethod();

        //Anonymous class Implementation
        Functional fun = new Functional() {
            @Override
            public void addition(int a, int b) {
                System.out.println("add: " + (a + b));
            }

            @Override
            public void defMethod() {
                System.out.println("Override Default method");
            }
        };
        fun.defMethod();
        fun.addition(30, 30);

        //
        Fun fun1 = (a, b) -> {
            System.out.println("Addition is: " + (a + b));
        };
        fun1.addition(10, 10);
    }
}
