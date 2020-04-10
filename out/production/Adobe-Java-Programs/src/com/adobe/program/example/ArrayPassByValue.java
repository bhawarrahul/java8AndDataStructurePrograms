package com.adobe.program.example;

import java.util.Arrays;

class Employee {
    private String name;
    private String empId;

    public Employee(String name, String empId) {
        this.name = name;
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }
}

public class ArrayPassByValue {
    public static void main(String[] args) {
        Employee[] emp = new Employee[4];
        emp[0] = new Employee("1", "1");
        emp[1] = new Employee("2", "2");
        emp[2] = new Employee("3", "3");
        emp[3] = new Employee("4", "4");
        changeEmployeeArray(emp);
        System.out.println(Arrays.toString(emp));

        Integer num = new Integer(20);
        String str = "rahul";
        changePrimitive(num, str);
        System.out.println(num + ": " + str);
    }

    private static void changeEmployeeArray(Employee[] employees) {
        employees[0] = new Employee("aaa", "Aaa");
        employees = new Employee[4];
        employees[1] = new Employee("aaa", "Aaa");
    }

    private static void changePrimitive(Integer num, String str) {
        num = 10;
        str = "abc";
    }
}
