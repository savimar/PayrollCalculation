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

        List<AbstractEmployee> employees = new ArrayList<>();

        Employee employee1 = new Employee(LocalDate.of(2017, 2, 6));

        System.out.println("employee1 " + employee1.getSalary(employee1, LocalDate.now()));

        Employee employee2 = new Employee();
        employee2.setEmploymentDate(LocalDate.of(2005, 1, 25));

        System.out.println("employee2 " + employee2.getSalary(employee2, LocalDate.now()));

        employees.add(employee1);
        employees.add(employee2);

        Sales sales1 = new Sales();
        sales1.setEmploymentDate(LocalDate.of(2017, 8, 17));
        sales1.setSubordinates(employees);

        System.out.println("sales1 " + sales1.getSalary(sales1, LocalDate.now()));

        List<AbstractEmployee> employees1 = new ArrayList<>();
        employees1.add(employee1);
        employees1.add(employee2);
        employees1.add(sales1);

        Manager manager1 = new Manager();
        manager1.setSubordinates(employees1);
        manager1.setEmploymentDate(LocalDate.of(2016, 6, 28));


        System.out.println("manager1 " + manager1.getSalary(manager1, LocalDate.now()));

        List<AbstractEmployee> employees2 = new ArrayList<>();

        Employee employee3 = new Employee();
        employee3.setEmploymentDate(LocalDate.of(2017, 2, 6));

        System.out.println("employee3 " + employee3.getSalary(employee3, LocalDate.now()));

        Employee employee4 = new Employee();
        employee4.setEmploymentDate(LocalDate.of(2005, 1, 25));

        System.out.println("employee4 " + employee4.getSalary(employee4, LocalDate.now()));


        employees2.add(employee3);
        employees2.add(employee4);
        employees2.add(manager1);


        Manager manager2 = new Manager();
        manager2.setEmploymentDate(LocalDate.of(2010, 8, 9));
        manager2.setSubordinates(employees2);

        System.out.println("manager2 " + manager2.getSalary(manager2, LocalDate.now()));

        List<AbstractEmployee> employees3 = new ArrayList<>();

        employees3.add(manager2);
        employees3.add(sales1);
        employees3.add(employee2);

        Sales sales2 = new Sales();
        sales2.setEmploymentDate(LocalDate.of(2013, 2, 12));
        sales2.setSubordinates(employees3);

        System.out.println("sales2 " + sales2.getSalary(sales2, LocalDate.now()));


    }
}
