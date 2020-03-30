package com.adobe.program.java8;


import java.util.Optional;

class OptionalClassExample {
    private String name;
}

public class OptionalClass {
    public static void main(String[] args) {
        Optional<OptionalClass> optionalClass = Optional.empty();
        System.out.println(optionalClass.isPresent());
        System.out.println(optionalClass.toString());
        System.out.println(optionalClass);

        Optional<OptionalClassExample> optional = Optional.of(new OptionalClassExample());
        System.out.println("Present : " + optional.isPresent());

        //
        optional = Optional.ofNullable(null);
        System.out.println("Present ofNullable: " + optional.isPresent());
        System.out.println("Get ofNullable: " + optional.getClass());
    }
}
