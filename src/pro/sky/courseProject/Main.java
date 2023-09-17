package pro.sky.courseProject;

public class Main {
    private static final Employee[] employees = new Employee[10];
    public static void main(String[] args) {
        employees[0] = new Employee("Иванов Иван Иванович", 1, 50000);
        employees[1] = new Employee("Петров Петр Петрович", 2, 55000);
        employees[2] = new Employee("Сидоров Сидор Сидорович", 3, 60000);
        employees[3] = new Employee("Власова Елена Васильевна", 4, 65000);
        employees[4] = new Employee("Смирнова Анна Васильевна", 5, 70000);

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
        System.out.println("Ф. И. О. всех сотрудников:");

        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }
}