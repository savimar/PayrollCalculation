package ru.savimar.payroll.service;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class EmployeeServiceTest extends TestData {

    @Test(expected = ArithmeticException.class)
    public void calculateSalaryException() {
        employee2.getSalary(employee2, LocalDate.of(2014, 5, 7));
    }

    @Test
    public void calculateSalaryEmployee1() {
        BigDecimal salary = employee1.getSalary(employee1, LocalDate.of(2018, 4, 1));
        double years = 2018 - 2007;
        double q = 0.03 * years;
        q = q > 0.3 ? 0.3 : q;
        double s = 20000 + (20000 * q);

        assertEquals(BigDecimal.valueOf(s).setScale(2, RoundingMode.HALF_UP), employee1Salary);
        assertEquals(employee1Salary, salary.setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    public void calculateSalaryEmployee2() {
        BigDecimal salary = employee2.getSalary(employee2, LocalDate.of(2018, 4, 1));
        long s = 20000 + (long) (20000 * ((2018 - 2015) * 0.03));
        assertEquals(BigDecimal.valueOf(s).setScale(2, RoundingMode.HALF_UP), employee2Salary);
        assertEquals(employee2Salary, salary.setScale(2, RoundingMode.HALF_UP));
    }
    @Test
    public void calculateSalaryEmployee3() {
        BigDecimal salary = employee3.getSalary(employee3, LocalDate.of(2018, 4, 1));

        assertEquals(employee3Salary, salary.setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    public void calculateSalaryEmployee4() {
        BigDecimal salary = employee4.getSalary(employee4, LocalDate.of(2018, 4, 1));

        assertEquals(employee4Salary, salary.setScale(2, RoundingMode.HALF_UP));
    }


}