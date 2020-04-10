package com.adobe.program.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class CustomerObjectGroupBy {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
                new Employee("Rahul", 27),
                new Employee("Glow", 28),
                new Employee("John", 28)
        );
        // Group by  map<age, List<Employee>>
        Map<Integer, List<Employee>> emp = list.stream()
                .collect(Collectors
                        .groupingBy(emp1 -> emp1.getAge(), Collectors.toList()));
        System.out.println(emp.toString());

        //Method Ref.
        Map<Integer, List<Employee>> emp1 = list.stream()
                .collect(Collectors
                        .groupingBy(Employee::getAge, Collectors.toList()));
        System.out.println(emp1.toString());

        //Group by with Max age
        Map<Integer, Optional<Employee>> maxAge = list.stream()
                .collect(Collectors
                        .groupingBy(
                                Employee::getAge,
                                Collectors.reducing(BinaryOperator.maxBy((e1, e2) -> e1.getAge() - e2.getAge())))
                );
        System.out.println(maxAge.toString());

        //Sum of all Employee age
        int totalAge = list.parallelStream().
                map(employee -> employee.getAge())
                .reduce(0, Integer::sum);
        System.out.println("Total Age: " + totalAge);
        totalAge = list.parallelStream().
                mapToInt(employee -> employee.getAge()).sum();
        System.out.println("Total Age 1: " + totalAge);
    }
}
