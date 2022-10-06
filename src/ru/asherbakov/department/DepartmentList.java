package ru.asherbakov.department;

public class DepartmentList {
    private static Department[] departments = new Department[5];

    public DepartmentList() {
        departments[0] = new Department("Отдел информационных технологий");
        departments[1] = new Department("Отдел по защите информации");
        departments[2] = new Department("Отдел кадров");
        departments[3] = new Department("Бухгалтерия");
        departments[4] = new Department("Отдел материального обеспечения");
    }

    public static Department[] getDepartments() {
        return departments;
    }


}
