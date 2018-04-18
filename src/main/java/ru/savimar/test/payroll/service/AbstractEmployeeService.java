package ru.savimar.test.payroll.service;

import ru.savimar.test.payroll.model.AbstractEmployee;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

public class AbstractEmployeeService {
    BigDecimal salarySub = BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_UP);


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


    BigDecimal calculateSalarySubordinates(AbstractEmployee employee, LocalDate date, BigDecimal percent) {


         salarySub=  salarySub.add(employee.getSalary(employee, date));
       /* AbstractEmployee abstractEmployee = list.get(list.size() - 1);
        salarySub = salarySub.add(salarySub.add(abstractEmployee.getSalary(abstractEmployee, date)));
        list.remove(abstractEmployee);
        if (list.size() > 0) {
            calculateSalarySubordinates(list, date, percent);
        }*/
        return salarySub.multiply(percent).setScale(2, RoundingMode.HALF_UP);



    }

    }





