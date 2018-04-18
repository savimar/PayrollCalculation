package ru.savimar.test.payroll.service;

import ru.savimar.test.payroll.model.AbstractEmployee;
import ru.savimar.test.payroll.model.Employee;
import ru.savimar.test.payroll.model.Manager;
import ru.savimar.test.payroll.model.Sales;
import ru.savimar.test.payroll.model.util.EmployeeCollection;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class AbstractEmployeeService {


    public BigDecimal calculateSalaryWithPercent(AbstractEmployee employee, BigDecimal percent, BigDecimal max, LocalDate date) {

        int years = date.getYear() - employee.getEmploymentDate().getYear();
        if (years < 0) {
            throw new ArithmeticException("The wage calculation date is shorter than the date of employment");
        }

        BigDecimal emploeePercent = BigDecimal.valueOf(years)
                .multiply(percent);

        if (emploeePercent.compareTo(max) > 0) {
            emploeePercent = max;
        }

        BigDecimal surcharge = employee.BASE_PAYROLL
                .multiply(emploeePercent);

        return employee.BASE_PAYROLL.add(surcharge.setScale(2, RoundingMode.HALF_UP));
    }


    public BigDecimal calculateSalarySubordinates(EmployeeCollection list, LocalDate date, BigDecimal percent) {
        BigDecimal salarySub = BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_UP);

        for (Object e:list) {
            if(e.getClass().isAssignableFrom(Employee.class)){
                EmployeeService employeeService = new EmployeeService();
                salarySub = salarySub.add (employeeService.calculateSalary((Employee)e, date));
       }
            else if(e.getClass().isAssignableFrom(Manager.class)){
                ManagerService managerService = new ManagerService();
                salarySub =  salarySub.add(managerService.calculateSalaryWithoutSubordinates((Manager)e, date));
            }
            else if(e.getClass().isAssignableFrom(Sales.class)){

            }
        }



        return salarySub.multiply(percent).setScale(2, RoundingMode.HALF_UP);


    }


}


