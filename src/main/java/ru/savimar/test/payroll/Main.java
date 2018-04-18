package ru.savimar.test.payroll;

import ru.savimar.test.payroll.model.AbstractEmployee;
import ru.savimar.test.payroll.model.Employee;
import ru.savimar.test.payroll.model.Manager;
import ru.savimar.test.payroll.model.Sales;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setEmploymentDate(LocalDate.of(2017, 02, 06));

        System.out.println("employee1 " + employee1.getSalary(employee1, LocalDate.now()));

        Employee employee2 = new Employee();
        employee2.setEmploymentDate(LocalDate.of(2005, 01, 25));

        System.out.println("employee2 " + employee2.getSalary(employee2, LocalDate.now()));


        List<AbstractEmployee> employees = new ArrayList<>();

        employees.add(employee1);
        employees.add(employee2);

        Manager manager1 = new Manager();
        manager1.setSubordinates(employees);
        manager1.setEmploymentDate(LocalDate.of(2016, 06, 28));


        System.out.println("manager1 " + manager1.getSalary(manager1, LocalDate.now()));

        Employee employee3 = new Employee();
        employee3.setEmploymentDate(LocalDate.of(2017, 02, 06));

        System.out.println("employee3 " + employee3.getSalary(employee3, LocalDate.now()));

        Employee employee4 = new Employee();
        employee4.setEmploymentDate(LocalDate.of(2005, 01, 25));

        System.out.println("employee4 " + employee4.getSalary(employee4, LocalDate.now()));

        employees.remove(employee1);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(manager1);


        Manager manager2 = new Manager();
        manager2.setEmploymentDate(LocalDate.of(2010, 8, 9));
        manager2.setSubordinates(employees);

        System.out.println("manager2 " + manager2.getSalary(manager2, LocalDate.now()));


        employees.add(manager2);
        employees.remove(employee3);

        Sales sales1 = new Sales();
        sales1.setEmploymentDate(LocalDate.of(2013, 02, 12));
        sales1.setSubordinates(employees);

        System.out.println("sales1 "+ sales1.getSalary(sales1, LocalDate.now()));


    }
}
