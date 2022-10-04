package ru.asherbakov.department;

public class Department {
    private String name;
    private int number;

    public Department(int number, String name) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Department{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
