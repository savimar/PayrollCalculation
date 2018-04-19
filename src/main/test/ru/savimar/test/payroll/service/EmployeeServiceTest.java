package ru.savimar.test.payroll.service;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static ru.savimar.test.payroll.service.TestData.*;

public class EmployeeServiceTest {

    @Test(expected = ArithmeticException.class)
    public void calculateSalaryException() {
        EMPLOYEE2.getSalary(EMPLOYEE2, LocalDate.of(2014, 5, 7));
    }

    @Test
    public void calculateSalaryEmployee1() {
        BigDecimal salary = EMPLOYEE1.getSalary(EMPLOYEE1, LocalDate.of(2018, 4, 1));
        double years = 2018 - 2007;
        double q = 0.03 * years;
        q = q > 0.3 ? 0.3 : q;
        double s = 20000 + (20000 * q);

        assertEquals(BigDecimal.valueOf(s).setScale(2, RoundingMode.HALF_UP), EMPLOYEE1_SALARY);
        assertEquals(EMPLOYEE1_SALARY, salary.setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    public void calculateSalaryEmployee2() {
        BigDecimal salary = EMPLOYEE2.getSalary(EMPLOYEE2, LocalDate.of(2018, 4, 1));
        long s = 20000 + (long) (20000 * ((2018 - 2015) * 0.03));
        assertEquals(BigDecimal.valueOf(s).setScale(2, RoundingMode.HALF_UP), EMPLOYEE2_SALARY);
        assertEquals(EMPLOYEE2_SALARY, salary.setScale(2, RoundingMode.HALF_UP));
    }


}