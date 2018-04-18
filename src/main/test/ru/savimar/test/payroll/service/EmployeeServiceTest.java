package ru.savimar.test.payroll.service;

import org.junit.Before;
import org.junit.Test;
import ru.savimar.test.payroll.model.Employee;

import java.time.LocalDate;

public class EmployeeServiceTest {
    private Employee employee1;
    private Employee employee2;


    @Before
    public void setUp() throws Exception {

        employee1 = new Employee();
        employee1.setEmploymentDate(LocalDate.of(2017, 2, 6));

        employee2 = new Employee();
        employee2.setEmploymentDate(LocalDate.of(2015, 1, 25));

    }

    @Test(expected = ArithmeticException.class)
    public void calculateSalaryException() {
        employee1.getSalary(employee1, LocalDate.of(2016, 05, 07));
    }
}