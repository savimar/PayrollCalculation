package ru.savimar.test.payroll.service;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ManagerServiceTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test(expected = ArithmeticException.class)
    public void calculateSalaryException() {
        TestData.MANAGER2.getSalary(TestData.MANAGER2, LocalDate.of(2016, 7, 9));
    }
    @Test
    public void calculateSalaryManager1() {

    }
}