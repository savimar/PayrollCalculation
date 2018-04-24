package ru.savimar.payroll.service;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class ManagerServiceTest extends TestData {



    @Test(expected = ArithmeticException.class)
    public void calculateSalaryException() {
        manager2.getSalary(manager2, LocalDate.of(2016, 7, 9));
    }

    @Test
    public void calculateSalaryManager1() {
        LocalDateTime prev = LocalDateTime.now();
        BigDecimal salary = manager1.getSalary(manager1, LocalDate.of(2018, 4, 1));
        double baseSalary = 20000 + ((2018 - 2014) * 0.05 * 20000);
        BigDecimal salarySub = employee1Salary.add(employee2Salary);
        salarySub = salarySub.multiply(BigDecimal.valueOf(0.005));
        BigDecimal salarySubAndBase = salarySub.add(BigDecimal.valueOf(baseSalary));

        assertEquals(salarySubAndBase.setScale(2, RoundingMode.HALF_UP), manager1Salary);
        assertEquals(manager1Salary, salary.setScale(2, RoundingMode.HALF_UP));
        System.out.println(" calculateSalaryManager1()  " + manager1Salary + " completed in " + (LocalDateTime.now().getNano() - prev.getNano()));

    }

    @Test
    public void calculateSalaryManager2() {
        BigDecimal salary = manager2.getSalary(manager2, LocalDate.of(2018, 4, 1));
        assertEquals(manager2Salary, salary.setScale(2, RoundingMode.HALF_UP));
    }
}