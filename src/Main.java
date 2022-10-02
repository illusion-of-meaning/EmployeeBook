import ru.asherbakov.Department;
import ru.asherbakov.employee.Employee;

public class Main {
    public static void main(String[] args) {
        // Формирование стартовых значений
        Department departmentIT = new Department("Отдел информационных технологий");
        Department departmentSecurity = new Department("Отдел по защите информации");
        Department departmentHR = new Department("Отдел кадров");
        Department departmentAccounting = new Department("Бухгалтерия");
        Department departmentMaterialSupport = new Department("Отдел материального обеспечения");

        Employee[] employee = new Employee[10];
        employee[0] = new Employee("Антон", "Юрьевич", "Щербаков", departmentIT, 50000);
        employee[1] = new Employee("Максим", "Владимирович", "Стропов", departmentSecurity, 54300);
        employee[2] = new Employee("Оксана", "Юрьевна", "Стразер", departmentAccounting, 48956.30);
        employee[3] = new Employee("Наталья", "Оверьяновна", departmentHR, 31280.50);
        employee[4] = new Employee("Валерий", "Фёдорович", "Краков", departmentSecurity, 49980);
        employee[5] = new Employee("Дмитрий", "Валентинович", "Прозоров", departmentIT, 61000);
        employee[6] = new Employee("Олег", "Александрович", "Дроздов", departmentMaterialSupport, 32800);
        employee[7] = new Employee("Юрий", "Александрович", "Манул", departmentSecurity, 44200);
        employee[8] = new Employee("Илья", "Анатольевич", "Гладышев", departmentIT, 35420);
        employee[9] = new Employee("Дмитрий", "Юрьевич", "Фролов", departmentIT, 50000);

        // Список сотрудников со всеми имеющимися по ним данными
        showAllEmployees(employee);
        System.out.println("==============================================");

        // Сумма затрат на зарплату в месяц
        double fullSalaryInMonthValue = fullSalaryInMonth(employee);
        System.out.println(String.format("Сумма затрат на зарплату в месяц: %.2f", fullSalaryInMonthValue));
        System.out.println("==============================================");

        // Выводим сотрудника с минимальной зарплатой
        Employee employeeWithLowestSalary = showEmployeeWithLowestSalary(employee);
        System.out.println("Сотрудник с наименьшей зарплатой:\n\t" + employeeWithLowestSalary);
        System.out.println("==============================================");

        // Выводим сотрудника с максимальной зарплатой
        Employee employeeWithHighestSalary = showEmployeeWithHighestSalary(employee);
        System.out.println("Сотрудник с наибольшей зарплатой:\n\t" + employeeWithHighestSalary);
        System.out.println("==============================================");

        // Среднее значение зарплат
        double averageSalary = showAverageSalary(fullSalaryInMonthValue, employee.length);
        System.out.println(String.format("Средняя зарплата в месяц: %.2f", averageSalary));
        System.out.println("==============================================");

        // Получаем ФИО всех сотрудников
        showAllEmployeesFIO(employee);
    }

    public static void showAllEmployees(Employee[] employee) {
        for (Employee emp : employee) {
            System.out.println(emp);
        }
    }

    public static void showAllEmployeesFIO(Employee[] employee) {
        for (Employee emp : employee) {
            String fio = "";
            if (emp.getMiddleName() != null && !emp.getMiddleName().isBlank()) {
                fio = String.format("%s %s %s", emp.getLastName(), emp.getFirstName(), emp.getMiddleName());
            } else {
                fio = String.format("%s %s", emp.getLastName(), emp.getFirstName());
            }
            System.out.println(fio);
        }
    }

    public static double fullSalaryInMonth(Employee[] employee) {
        double fullSalary = 0.0;
        for (Employee emp : employee) {
            fullSalary += emp.getSalary();
        }
        return fullSalary;
    }

    public static Employee showEmployeeWithLowestSalary(Employee[] employee) {
        double minSalary = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee emp : employee) {
            if (emp.getSalary() < minSalary) {
                minSalary = emp.getSalary();
                minSalaryEmployee = emp;
            }
        }
        return minSalaryEmployee;
    }

    public static Employee showEmployeeWithHighestSalary(Employee[] employee) {
        double maxSalary = Double.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (Employee emp : employee) {
            if (emp.getSalary() > maxSalary) {
                maxSalary = emp.getSalary();
                maxSalaryEmployee = emp;
            }
        }
        return maxSalaryEmployee;
    }

    public static double showAverageSalary(double fullSalaryInMonth, int employeeCount) {
        double result =  fullSalaryInMonth / employeeCount;
        return result;
    }
}