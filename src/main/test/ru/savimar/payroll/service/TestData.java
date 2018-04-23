package ru.savimar.payroll.service;

import org.junit.Before;
import ru.savimar.payroll.model.AbstractEmployee;
import ru.savimar.payroll.model.Employee;
import ru.savimar.payroll.model.Manager;
import ru.savimar.payroll.model.Sales;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestData {

    Employee employee1;
    BigDecimal employee1Salary;
    Employee employee2;
    BigDecimal employee2Salary;
    private List<AbstractEmployee> employees;
    Manager manager1;
    BigDecimal manager1Salary;
    Employee employee3;
    BigDecimal employee3Salary;
    Employee employee4;
    BigDecimal employee4Salary;
    private List<AbstractEmployee> employees1;
    Sales sales1;
    BigDecimal sales1Salary;
    private List<AbstractEmployee> employees2;
    Manager manager2;
    BigDecimal manager2Salary;
    private List<AbstractEmployee> employees3;
    Sales sales2;
    BigDecimal sales2Salary;

    @Before
    public void setUp() {

        employee1 = new Employee(LocalDate.of(2007, 2, 6));
        employee1Salary = BigDecimal.valueOf(26000.00).setScale(2, RoundingMode.HALF_UP);
        employee2 = new Employee(LocalDate.of(2015, 1, 25));
        employee2Salary = BigDecimal.valueOf(21800.00).setScale(2, RoundingMode.HALF_UP);

        employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        manager1 = new Manager(LocalDate.of(2014, 5, 28), employees);
        manager1Salary = BigDecimal.valueOf(24239.00).setScale(2, RoundingMode.HALF_UP);


        employee3 = new Employee(LocalDate.of(2014, 4, 19));
        employee3Salary = BigDecimal.valueOf(22400.00).setScale(2, RoundingMode.HALF_UP);

        employee4 = new Employee(LocalDate.of(2018, 1, 25));
        employee4Salary = BigDecimal.valueOf(20000.00).setScale(2, RoundingMode.HALF_UP);


        employees1 = new ArrayList<>();
        employees1.add(employee3);
        employees1.add(employee4);
        employees1.add(manager1);

        sales1 = new Sales(LocalDate.of(2012, 9, 15), employees1);
        sales1Salary = BigDecimal.valueOf(21543.32).setScale(2, RoundingMode.HALF_UP);


        employees2 = new ArrayList<>();
        employees2.add(employee2);
        employees2.add(sales1);
        employees2.add(manager1);


        manager2 = new Manager(LocalDate.of(2017, 3, 14), employees2);
        manager2Salary = BigDecimal.valueOf(21337.91).setScale(2, RoundingMode.HALF_UP);

        employees3 = new ArrayList<>();
        employees3.add(employee4);
        employees3.add(sales1);
        employees3.add(manager2);


        sales2 = new Sales(LocalDate.of(2018, 3, 22), employees3);
        sales2Salary = BigDecimal.valueOf(21221.42).setScale(2, RoundingMode.HALF_UP);



    }

}
