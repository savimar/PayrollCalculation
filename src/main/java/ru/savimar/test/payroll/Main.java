package ru.savimar.test.payroll;

import ru.savimar.test.payroll.model.AbstractEmployee;
import ru.savimar.test.payroll.model.Employee;
import ru.savimar.test.payroll.model.Manager;
import ru.savimar.test.payroll.model.util.EmployeeCollection;
import ru.savimar.test.payroll.service.EmployeeService;
import ru.savimar.test.payroll.service.ManagerService;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();

        Employee employee1 = new Employee();
        employee1.setEmploymentDate(LocalDate.of(2017, 02, 06));

        System.out.println("employee1 "+ employeeService.calculateSalary(employee1, LocalDate.now()));

        Employee employee2 = new Employee();
        employee2.setEmploymentDate(LocalDate.of(2005, 01, 25));

        System.out.println("employee2 "+ employeeService.calculateSalary(employee2, LocalDate.now()));


        EmployeeCollection employees = new EmployeeCollection();

        employees.add(employee1);
        employees.add(employee2);

        Manager manager1 = new Manager();
        manager1.setSubordinates(employees);
        manager1.setEmploymentDate(LocalDate.of(2016, 06, 28));

        ManagerService managerService = new ManagerService();

        System.out.println("manager1 " + managerService.calculateSalary(manager1, LocalDate.now()));

        Employee employee3 = new Employee();
        employee3.setEmploymentDate(LocalDate.of(2017, 02, 06));

        System.out.println("employee3 "+ employeeService.calculateSalary(employee3, LocalDate.now()));

        Employee employee4 = new Employee();
        employee4.setEmploymentDate(LocalDate.of(2005, 01, 25));

        System.out.println("employee4 "+ employeeService.calculateSalary(employee4, LocalDate.now()));

        employees.remove(employee1);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(manager1);

        Manager manager2 = new Manager();
        manager2.setEmploymentDate(LocalDate.of(2010, 8, 9));
        manager2.setSubordinates(employees);

        System.out.println("manager2 " + managerService.calculateSalary(manager1, LocalDate.now()));










    }
}
