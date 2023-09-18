package pro.sky.courseProject;

public class Main {
    private static Employee[] employees = new Employee[10];
    private static int size = 0;

    public static void main(String[] args) {
        addEmployee(new Employee("Иванов Иван Иванович", 1, 90000));
        addEmployee(new Employee("Джонов Джон Джонович", 1, 75000));
        addEmployee(new Employee("Майклов Майкл Майклович", 1, 80000));
        addEmployee(new Employee("Петров Петр Петрович", 2, 55000));
        addEmployee(new Employee("Сидоров Сидор Сидорович", 3, 60000));
        addEmployee(new Employee("Власова Елена Васильевна", 4, 45000));
        addEmployee(new Employee("Смирнова Анна Васильевна", 5, 70000));

        printAllEmployees();
        System.out.println(' ');
        calculateTotalSalary();
        System.out.println(' ');
        findMinSalary();
        System.out.println(' ');
        findMaxSalary();
        System.out.println(' ');
        calculateAverageSalary();
        System.out.println(' ');
        printEmployeeNames();

        System.out.println("\n    Зарплата с увеличеним на 10%:");
        increaseSalaryByPercentage(10);

        System.out.println(' ');

        findMinSalaryInDepartment(1);
        findMaxSalaryInDepartment(1);
        calculateTotalSalaryInDepartment(1);
        calculateAverageSalaryInDepartment(1);
        increaseSalaryInDepartmentByPercentage(1, 15);
        printEmployeesInDepartment(1);

        System.out.println(' ');

        findEmployeesWithSalaryGreaterThanOrEqual(60000);

        System.out.println(' ');

        findEmployeesWithSalaryLessThan(60000);

    }

    public static void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Массив сотрудников заполнен. Нельзя добавить нового сотрудника.");
        }
    }

    public static void printAllEmployees() {

        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static void calculateTotalSalary() {
        int totalSalary = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        System.out.println("Сумма затрат на зарплаты в месяц: " + totalSalary);
    }

    public static void findMinSalary() {
        Employee minSalaryEmployee = employees[0];

        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employees[i];
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee.getFullName());
    }

    public static void findMaxSalary() {
        Employee maxSalaryEmployee = employees[0];

        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employees[i];
            }
        }

        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee.getFullName());
    }

    public static void calculateAverageSalary() {
        int totalSalary = 0;
        int count = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
                count++;
            }
        }
        if (count > 0) {
            int averageSalary = totalSalary / count;
            System.out.println("Средняя зарплата сотрудников: " + averageSalary);
        }
    }

    public static void printEmployeeNames() {
        System.out.println("    Ф. И. О. всех сотрудников:");

        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }
    public static void increaseSalaryByPercentage(int percentage) {
        for (Employee employee : employees) {
            if (employee != null) {
                int currentSalary = employee.getSalary();
                int newSalary = currentSalary + (currentSalary * percentage / 100);
                employee.setSalary(newSalary);
                System.out.println("Зарплата сотрудника " + employee.getFullName() + " составляет " + newSalary);
            }
        }
    }


    public static void findMinSalaryInDepartment(int departmentNumber) {
        int minSalary = Integer.MAX_VALUE;
        Employee minSalaryEmployee = null;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                if (employee.getSalary() < minSalary) {
                    minSalary = employee.getSalary();
                    minSalaryEmployee = employee;
                }
            }
        }

        if (minSalaryEmployee != null) {
            System.out.println("Сотрудник с минимальной зарплатой в отделе " + departmentNumber + ": " + minSalaryEmployee.getFullName());
        } else {
            System.out.println("Отдел " + departmentNumber + " не содержит сотрудников.");
        }
    }

    public static void findMaxSalaryInDepartment(int departmentNumber) {
        int maxSalary = Integer.MIN_VALUE;
        Employee maxSalaryEmployee = null;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                if (employee.getSalary() > maxSalary) {
                    maxSalary = employee.getSalary();
                    maxSalaryEmployee = employee;
                }
            }
        }

        if (maxSalaryEmployee != null) {
            System.out.println("Сотрудник с максимальной зарплатой в отделе " + departmentNumber + ": " + maxSalaryEmployee.getFullName());
        } else {
            System.out.println("Отдел " + departmentNumber + " не содержит сотрудников.");
        }
    }

    public static void calculateTotalSalaryInDepartment(int departmentNumber) {
        int totalSalary = 0;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                totalSalary += employee.getSalary();
            }
        }

        System.out.println("Сумма затрат на зарплату в отделе " + departmentNumber + ": " + totalSalary);
    }

    public static void calculateAverageSalaryInDepartment(int departmentNumber) {
        int totalSalary = 0;
        int count = 0;

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                totalSalary += employee.getSalary();
                count++;
            }
        }

        if (count > 0) {
            int averageSalary = totalSalary / count;
            System.out.println("Средняя зарплата в отделе " + departmentNumber + ": " + averageSalary);
        } else {
            System.out.println("Отдел " + departmentNumber + " не содержит сотрудников.");
        }
    }

    public static void increaseSalaryInDepartmentByPercentage(int departmentNumber, int percentage) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                int currentSalary = employee.getSalary();
                int newSalary = currentSalary + (currentSalary * percentage / 100);
                employee.setSalary(newSalary);
            }
        }
    }

    public static void printEmployeesInDepartment(int departmentNumber) {
        System.out.println("    Сотрудники отдела " + departmentNumber + ":");

        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                System.out.println("ID: " + employee.getId() + ", Ф. И. О.: " + employee.getFullName() + ", Зарплата: " + employee.getSalary());
            }
        }
    }

    public static void findEmployeesWithSalaryLessThan(int salaryThreshold) {
        System.out.println("Сотрудники с зарплатой меньше " + salaryThreshold + ":");

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salaryThreshold) {
                System.out.println("ID: " + employee.getId() + ", Ф. И. О.: " + employee.getFullName() + ", Зарплата: " + employee.getSalary());
            }
        }
    }

    public static void findEmployeesWithSalaryGreaterThanOrEqual(int salaryThreshold) {
        System.out.println("Сотрудники с зарплатой больше или равной " + salaryThreshold + ":");

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salaryThreshold) {
                System.out.println("Id сотрудника: " + employee.getId() + "\n" + "Ф. И. О.: " + employee.getFullName() + ", Зарплата: " + employee.getSalary());
            }
        }
    }


}