package ru.asherbakov.employee;

import ru.asherbakov.department.Department;

public class Employee {
    private String firstName;
    private String middleName;
    private String lastName;
    private Department department;
    private double salary;
    private static int currentId;
    private int id;

    public Employee(String firstName, String lastName, Department department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        id = currentId + 1;
        currentId++;
    }

    public Employee(String firstName, String middleName, String lastName, Department department, double salary) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        id = currentId + 1;
        currentId++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String fio = "";
        if (middleName != null && !middleName.isBlank()) {
            fio = String.format("%s %s %s", lastName, firstName, middleName);
        } else {
            fio = String.format("%s %s", lastName, firstName);
        }
        return String.format("%s:\n\tотдел: %s\n\tзарплата: %.2f", fio, department.getName(), salary);
    }


}