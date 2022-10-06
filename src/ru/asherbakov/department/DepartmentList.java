package ru.asherbakov.department;

public class DepartmentList {
//    public static Department departmentIT = new Department(1, "Отдел информационных технологий");
//    public static Department departmentSecurity = new Department(2, "Отдел по защите информации");
//    public static Department departmentHR = new Department(3, "Отдел кадров");
//    public static Department departmentAccounting = new Department(4, "Бухгалтерия");
//    public static Department departmentMaterialSupport = new Department(5, "Отдел материального обеспечения");
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
