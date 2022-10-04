package ru.asherbakov.employee;

import ru.asherbakov.department.Department;
import ru.asherbakov.department.DepartmentList;

public class EmployeeBook {

    private Employee[] employee = new Employee[10];

    public EmployeeBook() {
        // Формирование стартовых значений
//        Department departmentIT = new Department(1, "Отдел информационных технологий");
//        Department departmentSecurity = new Department(2, "Отдел по защите информации");
//        Department departmentHR = new Department(3, "Отдел кадров");
//        Department departmentAccounting = new Department(4, "Бухгалтерия");
//        Department departmentMaterialSupport = new Department(5, "Отдел материального обеспечения");
        DepartmentList departmentList = new DepartmentList();

        employee[0] = new Employee("Антон", "Юрьевич", "Щербаков", departmentList.departmentIT, 50000);
        employee[1] = new Employee("Максим", "Владимирович", "Стропов", departmentList.departmentSecurity, 54300);
        employee[2] = new Employee("Оксана", "Юрьевна", "Стразер", departmentList.departmentAccounting, 48956.30);
        employee[3] = new Employee("Наталья", "Оверьяновна", departmentList.departmentHR, 31280.50);
        employee[4] = new Employee("Валерий", "Фёдорович", "Краков", departmentList.departmentSecurity, 49980);
        employee[5] = new Employee("Дмитрий", "Валентинович", "Прозоров", departmentList.departmentIT, 61000);
        employee[6] = new Employee("Олег", "Александрович", "Дроздов", departmentList.departmentMaterialSupport, 32800);
        employee[7] = new Employee("Юрий", "Александрович", "Манул", departmentList.departmentSecurity, 44200);
        employee[8] = new Employee("Илья", "Анатольевич", "Гладышев", departmentList.departmentIT, 35420);
        employee[9] = new Employee("Дмитрий", "Юрьевич", "Фролов", departmentList.departmentIT, 50000);
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

    public int getDepartmentLength(int department) {
        int departmentLength = 0;
        for (Employee emp : employee) {
            if (emp == null) continue;
            if (emp.getDepartment().getNumber() == department) {
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

    public double fullSalaryInMonth() {
        double fullSalary = 0.0;
        for (Employee emp : employee) {
            if (emp == null) continue;
            fullSalary += emp.getSalary();
        }
        return fullSalary;
    }

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

    public double showAverageSalary(double fullSalaryInMonth, int employeeCount) {
        double result = fullSalaryInMonth / employeeCount;
        return result;
    }

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

    // Методы для взаимодействия с отделом
    public double fullSalaryInMonth(int department) {
        double fullSalary = 0.0;
        for (Employee emp : employee) {
            if (emp == null) continue;
            if (emp.getDepartment().getNumber() != department) {
                continue;
            }
            fullSalary += emp.getSalary();
        }
        return fullSalary;
    }

    public Employee showEmployeeWithLowestSalary(int department) {
        double minSalary = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee emp : employee) {
            if (emp == null) continue;
            if (emp.getDepartment().getNumber() != department) {
                continue;
            }
            if (emp.getSalary() < minSalary) {
                minSalary = emp.getSalary();
                minSalaryEmployee = emp;
            }
        }
        return minSalaryEmployee;
    }

    public Employee showEmployeeWithHighestSalary(int department) {
        double maxSalary = Double.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (Employee emp : employee) {
            if (emp == null) continue;
            if (emp.getSalary() > maxSalary) {
                if (emp.getDepartment().getNumber() != department) {
                    continue;
                }
                maxSalary = emp.getSalary();
                maxSalaryEmployee = emp;
            }
        }
        return maxSalaryEmployee;
    }

    public void salaryIndex(double index, int department) {
        if (index <= 0) {
            throw new IllegalArgumentException("Индексация должна производиться на положительное значение.");
        }
        for (Employee emp : employee) {
            if (emp == null) continue;
            if (emp.getDepartment().getNumber() != department) {
                continue;
            }
            double newSalary = emp.getSalary() + (emp.getSalary() * index / 100);
            emp.setSalary(newSalary);
        }
    }

    public void showAllEmployees(int department) {
        for (Employee emp : employee) {
            if (emp == null) continue;
            if (emp.getDepartment().getNumber() != department) {
                continue;
            }
            System.out.println(String.format("Сотрудник %s\n\tзарплата: %s", getFio(emp), emp.getSalary()));
        }
    }

    public void showAllEmployeesWithHigherSalary(double salarySeparator) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) continue;
            if (employee[i].getSalary() > salarySeparator) {
                System.out.println(String.format("%s: %s, зарплата: %.2f", i, getFio(employee[i]), employee[i].getSalary()));
            }
        }
    }

    public void showAllEmployeesWithLowerSalary(double salarySeparator) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) continue;
            if (employee[i].getSalary() < salarySeparator) {
                System.out.println(String.format("%s: %s, зарплата: %.2f", i, getFio(employee[i]), employee[i].getSalary()));
            }
        }
    }

    public String getFio(Employee emp) {
        String fio = "";
        if (emp.getMiddleName() != null && !emp.getMiddleName().isBlank()) {
            fio = String.format("%s %s %s", emp.getLastName(), emp.getFirstName(), emp.getMiddleName());
        } else {
            fio = String.format("%s %s", emp.getLastName(), emp.getFirstName());
        }
        return fio;
    }

    // --- Часть "Очень сложно" ---
    //"Антон", "Юрьевич", "Щербаков", departmentIT, 50000
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

    public void addEmployee(String firstName, String lastName, Department department, double salary) {
        Employee emp = new Employee(firstName, lastName, department, salary);
        addEmployee(emp);
    }

    public void addEmployee(String firstName, String middleName, String lastName, Department department, double salary) {
        Employee emp = new Employee(firstName, middleName, lastName, department, salary);
        addEmployee(emp);
    }

    public void removeEmployee(int index) {
        employee[index] = null;
    }

    public void removeEmployee(String fio) {
        String[] temp = fio.split(" ");
        switch (temp.length) {
            case 2:
                removeEmployee(temp[0], temp[1]);
                break;
            case 3:
                removeEmployee(temp[0], temp[1], temp[2]);
                break;
            default:
                throw new IllegalArgumentException("Ошибка при определении ФИО.");
        }
    }

    public void removeEmployee(String lastName, String firstName) {
        boolean isRemoveFlag = false;
        for (int i = 0; i < employee.length - 1; i++) {
            if (employee[i] == null) continue;
            if (employee[i].getLastName().equalsIgnoreCase(lastName)
                    && employee[i].getFirstName().equalsIgnoreCase(firstName)) {
                employee[i] = null;
                isRemoveFlag = true;
                break;
            }
        }
        if (!isRemoveFlag) {
            System.err.println(String.format("Пользователь с данными фамилией/именем не найден:\n\t%s %s", lastName, firstName));
        }
    }

    public void removeEmployee(String lastName, String firstName, String middleName) {
        boolean isRemoveFlag = false;
        for (int i = 0; i < employee.length - 1; i++) {
            if (employee[i] == null) continue;
            if (employee[i].getLastName().equalsIgnoreCase(lastName)
                    && employee[i].getFirstName().equalsIgnoreCase(firstName)
                    && employee[i].getMiddleName().equalsIgnoreCase(middleName)) {
                employee[i] = null;
                isRemoveFlag = true;
                break;
            }
        }
        if (!isRemoveFlag) {
            System.err.println(String.format("Пользователь с данными ФИО не найден:\n\t%s %s %s", lastName, firstName, middleName));
        }
    }
}
