package ru.asherbakov.department;

import java.util.Objects;

public class Department {
    private String name;
//    private int number;

    public Department(String name) {
        this.name = name;
//        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getNumber() {
//        return number;
//    }

//    public void setNumber(int number) {
//        this.number = number;
//    }

    @Override
    public String toString() {
        return "Department{" +
//                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
