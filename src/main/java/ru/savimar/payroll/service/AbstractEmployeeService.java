package ru.savimar.payroll.service;


import ru.savimar.payroll.model.AbstractEmployee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

abstract class AbstractEmployeeService {
    BigDecimal salarySub = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);


    BigDecimal calculateSalaryWithPercent(AbstractEmployee employee, BigDecimal percent, BigDecimal max, LocalDate date) {

        int years = date.getYear() - employee.getEmploymentDate().getYear();
        if (years < 0) {
            throw new ArithmeticException("The wage calculation date is shorter than the date of employment");
        }

        BigDecimal employeePercent = BigDecimal.valueOf(years)
                .multiply(percent);

        if (employeePercent.compareTo(max) > 0) {
            employeePercent = max;
        }

        BigDecimal surcharge = employee.BASE_PAYROLL
                .multiply(employeePercent);

        return employee.BASE_PAYROLL.add(surcharge.setScale(2, RoundingMode.HALF_UP));
    }


    BigDecimal calculateSalaryOneEmployee(AbstractEmployee employee, LocalDate date) {

        BigDecimal salary = employee.getSalary(employee, date);

        return salarySub.add(salary.setScale(2, RoundingMode.HALF_UP));
    }

    BigDecimal calculateSalaryAllEmployees(List<AbstractEmployee> list, LocalDate date) {

        for (AbstractEmployee employee : list) {
            salarySub = calculateSalaryOneEmployee(employee, date);
        }

        return salarySub.setScale(2, RoundingMode.HALF_UP);
    }


}





