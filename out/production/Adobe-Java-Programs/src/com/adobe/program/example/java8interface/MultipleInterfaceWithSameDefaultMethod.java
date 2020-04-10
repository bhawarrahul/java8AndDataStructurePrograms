package com.adobe.program.example.java8interface;


interface First {
    void method();

    static void staticMethod() {
        System.out.println("First - Static ");
    }

    default void defaultMethod() {
        System.out.println("First - Default ");
    }
}

interface Second {
    void method();

    static void staticMethod() {
        System.out.println("Second - Static ");
    }

    default void defaultMethod() {
        System.out.println("Second - Default ");
    }
}


public class MultipleInterfaceWithSameDefaultMethod implements First, Second {
    @Override
    public void method() {
        System.out.println("Override Method ");
    }

    @Override
    public void defaultMethod() {
        First.super.defaultMethod();
        Second.super.defaultMethod();
        System.out.println("Override Default Method");
    }

    public static void main(String[] args) {
        First first = new MultipleInterfaceWithSameDefaultMethod();
        Second second = new MultipleInterfaceWithSameDefaultMethod();
        MultipleInterfaceWithSameDefaultMethod method = new MultipleInterfaceWithSameDefaultMethod();

        //1
        first.method();
        first.defaultMethod();
        //2
        second.method();
        second.defaultMethod();
        //3
        method.method();
        method.defaultMethod();


    }
}
