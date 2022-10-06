package ru.asherbakov.employee;

import ru.asherbakov.department.Department;
import ru.asherbakov.department.DepartmentList;

public class EmployeeBook {

    private Employee[] employee = new Employee[10];
    DepartmentList departmentList = new DepartmentList();

    public EmployeeBook() {
        // Формирование стартовых значений
        employee[0] = new Employee("Антон", "Юрьевич", "Щербаков", departmentList.getDepartments()[0], 50000);
        employee[1] = new Employee("Максим", "Владимирович", "Стропов", departmentList.getDepartments()[1], 54300);
        employee[2] = new Employee("Оксана", "Юрьевна", "Стразер", departmentList.getDepartments()[3], 48956.30);
        employee[3] = new Employee("Наталья", "Оверьяновна", departmentList.getDepartments()[2], 31280.50);
        employee[4] = new Employee("Валерий", "Фёдорович", "Краков", departmentList.getDepartments()[1], 49980);
        employee[5] = new Employee("Дмитрий", "Валентинович", "Прозоров", departmentList.getDepartments()[0], 61000);
        employee[6] = new Employee("Олег", "Александрович", "Дроздов", departmentList.getDepartments()[4], 32800);
        employee[7] = new Employee("Юрий", "Александрович", "Манул", departmentList.getDepartments()[1], 44200);
        employee[8] = new Employee("Илья", "Анатольевич", "Гладышев", departmentList.getDepartments()[0], 35420);
        employee[9] = new Employee("Дмитрий", "Юрьевич", "Фролов", departmentList.getDepartments()[0], 50000);
    }

    public Employee[] getEmployee() {
        return employee;
    }

    public void setEmployee(Employee[] employee) {
        this.employee = employee;
    }

    public int employeeLength() {
        return employee.length;
    }

    /**
     * Получение количества сотрудников в отделе
     *
     * @param department
     * @return
     */
    public int getDepartmentLength(int department) {
        int departmentLength = 0;
        for (Employee emp : employee) {
            if (emp == null) continue;
            if (isDepartmentEquals(emp, department)) {
                departmentLength++;
            }
        }
        return departmentLength;
    }

    public void showAllEmployees() {
        for (Employee emp : employee) {
            if (emp == null) continue;
            System.out.println(emp);
        }
    }

    public void showAllEmployeesFIO() {
        for (Employee emp : employee) {
            if (emp == null) continue;
            System.out.println(getFio(emp));
        }
    }

    /**
     * Затраты на зарплату в месяц
     *
     * @return
     */
    public double fullSalaryInMonth() {
        double fullSalary = 0.0;
        for (Employee emp : employee) {
            if (emp == null) continue;
            fullSalary += emp.getSalary();
        }
        return fullSalary;
    }

    /**
     * Получение сотрудника (одного), с наименьшей зарплатой
     *
     * @return
     */
    public Employee showEmployeeWithLowestSalary() {
        double minSalary = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee emp : employee) {
            if (emp == null) continue;
            if (emp.getSalary() < minSalary) {
                minSalary = emp.getSalary();
                minSalaryEmployee = emp;
            }
        }
        return minSalaryEmployee;
    }

    /**
     * Получение сотрудника (одного), с наибольшей зарплатой
     *
     * @return
     */
    public Employee showEmployeeWithHighestSalary() {
        double maxSalary = Double.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (Employee emp : employee) {
            if (emp == null) continue;
            if (emp.getSalary() > maxSalary) {
                maxSalary = emp.getSalary();
                maxSalaryEmployee = emp;
            }
        }
        return maxSalaryEmployee;
    }

    /**
     * Средняя зарплата
     *
     * @param fullSalaryInMonth
     * @param employeeCount
     * @return
     */
    public double showAverageSalary(double fullSalaryInMonth, int employeeCount) {
        double result = fullSalaryInMonth / employeeCount;
        return result;
    }

    /**
     * Индексация зарплат сотрудников
     *
     * @param index
     */
    public void salaryIndex(double index) {
        if (index <= 0) {
            throw new IllegalArgumentException("Индексация должна производиться на положительное значение.");
        }
        for (Employee emp : employee) {
            if (emp == null) continue;
            double newSalary = emp.getSalary() + (emp.getSalary() * index / 100);
            emp.setSalary(newSalary);
        }
    }

    // ---- Методы для взаимодействия с отделом ----

    /**
     * Затраты на зарплату в месяц по отделу
     *
     * @param department
     * @return
     */
    public double fullSalaryInMonth(int department) {
        double fullSalary = 0.0;
        for (Employee emp : employee) {
            if (emp == null) continue;
            if (!isDepartmentEquals(emp, department)) {
                continue;
            }
            fullSalary += emp.getSalary();
        }
        return fullSalary;
    }

    /**
     * Получение сотрудника (одного), с наименьшей зарплатой в отделе
     *
     * @param department
     * @return
     */
    public Employee showEmployeeWithLowestSalary(int department) {
        double minSalary = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee emp : employee) {
            if (emp == null) continue;
            if (!isDepartmentEquals(emp, department)) {
                continue;
            }
            if (emp.getSalary() < minSalary) {
                minSalary = emp.getSalary();
                minSalaryEmployee = emp;
            }
        }
        return minSalaryEmployee;
    }

    /**
     * Получение сотрудника (одного), с наибольшей зарплатой в отделе
     *
     * @param department
     * @return
     */
    public Employee showEmployeeWithHighestSalary(int department) {
        double maxSalary = Double.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (Employee emp : employee) {
            if (emp == null) continue;
            if (emp.getSalary() > maxSalary) {
                if (!isDepartmentEquals(emp, department)) {
                    continue;
                }
                maxSalary = emp.getSalary();
                maxSalaryEmployee = emp;
            }
        }
        return maxSalaryEmployee;
    }

    /**
     * Индексация зарплат сотрудников в отделе
     *
     * @param index
     * @param department
     */
    public void salaryIndex(double index, int department) {
        if (index <= 0) {
            throw new IllegalArgumentException("Индексация должна производиться на положительное значение.");
        }
        for (Employee emp : employee) {
            if (emp == null) continue;
            if (!isDepartmentEquals(emp, department)) {
                continue;
            }
            double newSalary = emp.getSalary() + (emp.getSalary() * index / 100);
            emp.setSalary(newSalary);
        }
    }

    /**
     * Вывод на экран всех сотрудников, работающих в отделе
     *
     * @param department
     */
    public void showAllEmployees(int department) {
        for (Employee emp : employee) {
            if (emp == null) continue;
            if (!isDepartmentEquals(emp, department)) {
                continue;
            }
            System.out.println(String.format("Сотрудник %s\n\tзарплата: %.2f", getFio(emp), emp.getSalary()));
        }
    }

    /**
     * Вывод на экран сотрудников, заработная плата которых выше заданного значения
     *
     * @param salarySeparator
     */
    public void showAllEmployeesWithHigherSalary(double salarySeparator) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) continue;
            if (employee[i].getSalary() > salarySeparator) {
                System.out.println(String.format("%s: %s, зарплата: %.2f", i, getFio(employee[i]), employee[i].getSalary()));
            }
        }
    }

    /**
     * Вывод на экран сотрудников, заработная плата которых ниже заданного значения
     *
     * @param salarySeparator
     */
    public void showAllEmployeesWithLowerSalary(double salarySeparator) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) continue;
            if (employee[i].getSalary() < salarySeparator) {
                System.out.println(String.format("%s: %s, зарплата: %.2f", i, getFio(employee[i]), employee[i].getSalary()));
            }
        }
    }

    /**
     * Получение ФИО сотрудника
     *
     * @param emp
     * @return
     */
    public String getFio(Employee emp) {
        String fio = "";
        if (emp.getMiddleName() != null && !emp.getMiddleName().isBlank()) {
            fio = String.format("%s %s %s", emp.getLastName(), emp.getFirstName(), emp.getMiddleName());
        } else {
            fio = String.format("%s %s", emp.getLastName(), emp.getFirstName());
        }
        return fio;
    }

    // ---- Часть "Очень сложно" ----

    /**
     * Добавление сотрудника
     *
     * @param emp
     */
    public void addEmployee(Employee emp) {
        boolean isEmptyFlag = false;
        for (int i = 0; i < employee.length - 1; i++) {
            if (employee[i] == null) {
                employee[i] = emp;
                isEmptyFlag = true;
                break;
            }
        }
        if (!isEmptyFlag) {
            System.err.println("Для добавления нового сотрудника не хватает места.");
        }
    }

    /**
     * Добавление сотрудника (без указания отчества)
     *
     * @param firstName
     * @param lastName
     * @param department
     * @param salary
     */
    public void addEmployee(String firstName, String lastName, Department department, double salary) {
        Employee emp = new Employee(firstName, lastName, department, salary);
        addEmployee(emp);
    }

    /**
     * Добавление сотрудника
     *
     * @param firstName
     * @param middleName
     * @param lastName
     * @param department
     * @param salary
     */
    public void addEmployee(String firstName, String middleName, String lastName, Department department, double salary) {
        Employee emp = new Employee(firstName, middleName, lastName, department, salary);
        addEmployee(emp);
    }

    /**
     * Удаление сотрудника по индексу
     *
     * @param index
     */
    public void removeEmployee(int index) {
        employee[index] = null;
    }

    /**
     * Удаление сотрудника по ФИО
     *
     * @param fio
     */
    public void removeEmployee(String fio) {
        String[] temp = fio.split(" ");
        switch (temp.length) {
            case 2:
                removeEmployee(findEmployeeIndexByName(temp[0], temp[1]));
                break;
            case 3:
                removeEmployee(findEmployeeIndexByName(temp[0], temp[1], temp[2]));
                break;
            default:
                throw new IllegalArgumentException("Ошибка при определении ФИО.");
        }
    }

    /**
     * Поиск индекса сотрудника по фамилии/имени
     *
     * @param lastName
     * @param firstName
     * @return
     */
    public int findEmployeeIndexByName(String lastName, String firstName) {
        boolean isRemoveFlag = false;
        int index = 0;
        for (int i = 0; i < employee.length - 1; i++) {
            if (employee[i] == null) continue;
            if (employee[i].getLastName().equalsIgnoreCase(lastName)
                    && employee[i].getFirstName().equalsIgnoreCase(firstName)) {
                index = i;
                isRemoveFlag = true;
                break;
            }
        }
        if (!isRemoveFlag) {
            System.err.println(String.format("Пользователь с данными фамилией/именем не найден:\n\t%s %s", lastName, firstName));
        }
        return index;
    }

    /**
     * Поиск индекса сотрудника по ФИО
     *
     * @param lastName
     * @param firstName
     * @return
     */
    public int findEmployeeIndexByName(String lastName, String firstName, String middleName) {
        boolean isRemoveFlag = false;
        int index = 0;
        for (int i = 0; i < employee.length - 1; i++) {
            if (employee[i] == null) continue;
            if (employee[i].getLastName().equalsIgnoreCase(lastName)
                    && employee[i].getFirstName().equalsIgnoreCase(firstName)
                    && employee[i].getMiddleName().equalsIgnoreCase(middleName)) {
                index = i;
                isRemoveFlag = true;
                break;
            }
        }
        if (!isRemoveFlag) {
            System.err.println(String.format("Пользователь с данными ФИО не найден:\n\t%s %s %s", lastName, firstName, middleName));
        }
        return index;
    }

    /**
     * Изменение зарплаты сотруднику
     *
     * @param index
     * @param newSalary
     */
    public void rewriteEmployee(int index, double newSalary) {
        employee[index].setSalary(newSalary);
    }

    /**
     * Изменение отдела сотруднику
     *
     * @param index
     * @param newDepartment
     */
    public void rewriteEmployee(int index, Department newDepartment) {
        employee[index].setDepartment(newDepartment);
    }

    /**
     * Изменение зарплаты сотруднику
     *
     * @param fio
     * @param newSalary
     */
    public void rewriteEmployee(String fio, double newSalary) {
        String[] temp = fio.split(" ");
        int index = -1;
        switch (temp.length) {
            case 2:
                index = findEmployeeIndexByName(temp[0], temp[1]);
                break;
            case 3:
                index = findEmployeeIndexByName(temp[0], temp[1], temp[2]);
                break;
            default:
                throw new IllegalArgumentException("Ошибка при определении ФИО.");
        }
        if (index >= 0) {
            rewriteEmployee(index, newSalary);
        }
    }

    /**
     * Изменение отдела сотруднику
     *
     * @param fio
     * @param newDepartment
     */
    public void rewriteEmployee(String fio, Department newDepartment) {
        String[] temp = fio.split(" ");
        int index = -1;
        switch (temp.length) {
            case 2:
                index = findEmployeeIndexByName(temp[0], temp[1]);
                break;
            case 3:
                index = findEmployeeIndexByName(temp[0], temp[1], temp[2]);
                break;
            default:
                throw new IllegalArgumentException("Ошибка при определении ФИО.");
        }
        if (index >= 0) {
            rewriteEmployee(index, newDepartment);
        }
    }

    /**
     * Список сотрудников по отделам
     */
    public void showAllEmployeeFromDepartment() {
        for (Department department : departmentList.getDepartments()) {
            if (department == null) continue;
            System.out.println("!" + department.getName() + ":");
            for (Employee emp : employee) {
                if (emp == null) continue;
                if (emp.getDepartment().equals(department)) {
                    System.out.println(emp);
                }
            }
        }
    }

    private boolean isDepartmentEquals(Employee emp, int department) {
        boolean result = emp.getDepartment().getName().equalsIgnoreCase(departmentList.getDepartments()[department].getName());
        return result;
    }
}
