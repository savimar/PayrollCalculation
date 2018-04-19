package ru.savimar.test.payroll.service;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static ru.savimar.test.payroll.service.TestData.*;

public class SalesServiceTest {


    @Test(expected = ArithmeticException.class)
    public void calculateSalaryException() {
        SALES2.getSalary(SALES2, LocalDate.of(2017, 7, 9));
    }
    @Test
    public void calculateSalary() {
    }
}