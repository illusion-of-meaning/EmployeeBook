package ru.asherbakov;

import ru.asherbakov.department.DepartmentList;
import ru.asherbakov.employee.Employee;
import ru.asherbakov.employee.EmployeeBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        // Список сотрудников со всеми имеющимися по ним данными
        employeeBook.showAllEmployees();
        System.out.println("==============================================");

        // Сумма затрат на зарплату в месяц
        double fullSalaryInMonthValue = employeeBook.fullSalaryInMonth();
        System.out.println(String.format("Сумма затрат на зарплату в месяц: %.2f", fullSalaryInMonthValue));
        System.out.println("==============================================");

        // Выводим сотрудника с минимальной зарплатой
        Employee employeeWithLowestSalary = employeeBook.showEmployeeWithLowestSalary();
        System.out.println("Сотрудник с наименьшей зарплатой:\n\t" + employeeWithLowestSalary);
        System.out.println("==============================================");

        // Выводим сотрудника с максимальной зарплатой
        Employee employeeWithHighestSalary = employeeBook.showEmployeeWithHighestSalary();
        System.out.println("Сотрудник с наибольшей зарплатой:\n\t" + employeeWithHighestSalary);
        System.out.println("==============================================");

        // Среднее значение зарплат
        double averageSalary = employeeBook.showAverageSalary(fullSalaryInMonthValue, employeeBook.employeeLength());
        System.out.println(String.format("Средняя зарплата в месяц: %.2f", averageSalary));
        System.out.println("==============================================");

        // Получаем ФИО всех сотрудников
        employeeBook.showAllEmployeesFIO();

        // --- Повышенная сложность, работа с отделом ---
        final int DEPARTMENT_NUM = 1;
        // Проводим индексацию зарплаты
        double indexPercent = 3.6;
        employeeBook.salaryIndex(indexPercent);
        System.out.println(String.format("После проведения индексации на %f%%", indexPercent));
        employeeBook.showAllEmployees();
        System.out.println("==============================================");

        // Выводим сотрудника с минимальной зарплатой в отделе
        Employee employeeWithLowestSalaryInDepartment = employeeBook.showEmployeeWithLowestSalary(DEPARTMENT_NUM);
        System.out.println("Сотрудник с наименьшей зарплатой в отделе:\n\t" + employeeWithLowestSalaryInDepartment);
        System.out.println("==============================================");

        // Выводим сотрудника с максимальной зарплатой в отделе
        Employee employeeWithHighestSalaryInDepartment = employeeBook.showEmployeeWithHighestSalary(DEPARTMENT_NUM);
        System.out.println("Сотрудник с наибольшей зарплатой в отделе:\n\t" + employeeWithHighestSalaryInDepartment);
        System.out.println("==============================================");

        // Сумма затрат на зарплату в месяц по отделу
        double fullSalaryInMonthValueInDepartment = employeeBook.fullSalaryInMonth(DEPARTMENT_NUM);
        System.out.println(String.format("Сумма затрат на зарплату в месяц по отделу № %s: %.2f", DEPARTMENT_NUM, fullSalaryInMonthValueInDepartment));
        System.out.println("==============================================");

        // Средняя зарплата по отделу
        // Кол-во сотрудников в отделе
        int departmentLength = employeeBook.getDepartmentLength(DEPARTMENT_NUM);
        double averageSalaryInDepartment = employeeBook.showAverageSalary(fullSalaryInMonthValueInDepartment, departmentLength);
        System.out.println(String.format("Средняя зарплата в месяц по отделу № %s: %.2f", DEPARTMENT_NUM, averageSalaryInDepartment));
        System.out.println("==============================================");

        // Индексация зарплат по отделу
        indexPercent = 4.2;
        System.out.println(String.format("Произведена индексация зарплат на %.2f для отдела № %s", indexPercent, DEPARTMENT_NUM));
        employeeBook.salaryIndex(indexPercent, DEPARTMENT_NUM);

        // Печатаем сотрудников отдела
        System.out.println("Сотрудники отдела №" + DEPARTMENT_NUM);
        employeeBook.showAllEmployees(DEPARTMENT_NUM);
        System.out.println("==============================================");

        // Получить число и вывести сотрудников
        System.out.print("Введите сумму, относительно которой будут показаны зарплаты сотрудников: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double salarySeparator = 0.0;
        try {
            salarySeparator = Integer.valueOf(reader.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // с зарплатами больше указанных
        System.out.println("Зарплата больше " + salarySeparator);
        employeeBook.showAllEmployeesWithHigherSalary(salarySeparator);
        // с зарплатами меньше указанных
        System.out.println("Зарплата меньше " + salarySeparator);
        employeeBook.showAllEmployeesWithLowerSalary(salarySeparator);
        System.out.println("==============================================");

        // --- Часть "Очень сложно" ---
        // Добавляем сотрудника
        DepartmentList departmentList = new DepartmentList();
        Employee newEmployee = new Employee("Денис", "Александрович", "Звягинцев", departmentList.departmentIT, 52642.80);
        System.out.println("-=Сотрудники до внесения изменений=-");
        employeeBook.showAllEmployeesFIO();
        System.out.println("Попытка добавить сотрудника: " + newEmployee);
        // TODO: Если раскомментировать следующую строку, можно проверить возникновение ошибки при попытке добавить нового сотрудника в полностью заполненную базу
//        employeeBook.addEmployee(newEmployee);

        // Удаляем сотрудника по ФИО
        String removeFio1 = "Стропов Максим Владимирович";
        System.out.println("Попытка удалить сотрудника: " + removeFio1);
        employeeBook.removeEmployee(removeFio1);
        String removeFio2 = "Оверьяновна Наталья";
        System.out.println("Попытка удалить сотрудника: " + removeFio2);
        employeeBook.removeEmployee(removeFio2);
//        String removeFio3 = "Подопытная Обезьянка";
//        System.out.println("Попытка удалить сотрудника: " + removeFio3);
//        employeeBook.removeEmployee(removeFio3);

        // Удаляем сотрудника по id
        employeeBook.removeEmployee(0);

        // Добавляем сотрудника
        System.out.println("Попытка добавить сотрудника: " + newEmployee);
        employeeBook.addEmployee(newEmployee);
        System.out.println("-=Сотрудники после внесения изменений=-");
        employeeBook.showAllEmployeesFIO();

    }


}