package ru.savimar.test.payroll.service;



import ru.savimar.test.payroll.model.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;



public class EmployeeService extends AbstractEmployeeService implements IAbstractEmployeeService<Employee> {

    private static final BigDecimal PERCENT = new BigDecimal(0.03).setScale(2, RoundingMode.HALF_UP);
    private static final BigDecimal MAX = new BigDecimal(0.3).setScale(2, RoundingMode.HALF_UP);


    @Override
    public BigDecimal calculateSalary(Employee employee, LocalDate date) {
        return calculateSalaryWithPercent(employee, PERCENT, MAX, date);
    }
}
