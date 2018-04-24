package ru.savimar.payroll.service;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


public class SalesServiceTest extends TestData {


    @Test(expected = ArithmeticException.class)
    public void calculateSalaryException() {
        sales2.getSalary(sales2, LocalDate.of(2017, 7, 9));
    }

    @Test
    public void calculateSalarySales1() {
        LocalDateTime prev = LocalDateTime.now();
        BigDecimal salary = sales1.getSalary(sales1, LocalDate.of(2018, 4, 1));
        double baseSalary = 20000 + ((2018 - 2012) * 0.01 * 20000);
        BigDecimal salarySub = manager1Salary.add(employee2Salary).add(employee1Salary).add(employee4Salary.add(employee3Salary));
        salarySub = salarySub.multiply(BigDecimal.valueOf(0.003));
        BigDecimal salarySubAndBase = salarySub.add(BigDecimal.valueOf(baseSalary));

        assertEquals(salarySubAndBase.setScale(2, RoundingMode.HALF_UP), sales1Salary);
        assertEquals(sales1Salary, salary.setScale(2, RoundingMode.HALF_UP));
        System.out.println("calculateSalarySales1() " + sales1Salary + " completed in " + (LocalDateTime.now().getNano() - prev.getNano()));
    }

    @Test
    public void calculateSalarySales2() {
        BigDecimal salary = sales2.getSalary(sales2, LocalDate.of(2018, 4, 1));

        assertEquals(sales2Salary, salary.setScale(2, RoundingMode.HALF_UP));
    }
}

