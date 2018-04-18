package ru.savimar.test.payroll.service;

import ru.savimar.test.payroll.model.AbstractEmployee;
import ru.savimar.test.payroll.model.EmployeeEnum;
import ru.savimar.test.payroll.model.Manager;

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


    BigDecimal calculateSalaryOneEmployee(AbstractEmployee employee, LocalDate date) {
        BigDecimal salary = salarySub.add(employee.getSalary(employee, date));
        return salary.setScale(2, RoundingMode.HALF_UP);


    }

    BigDecimal calculateSalaryAllSubordinates(List<AbstractEmployee> list, LocalDate date, BigDecimal percentSub) {
        for (AbstractEmployee abstractEmployee : list) {
            if (abstractEmployee.getType().equals(EmployeeEnum.EMPLOYEE)) {
                salarySub = salarySub.add(calculateSalaryOneEmployee(abstractEmployee, date));
                salarySub = salarySub.multiply(percentSub);

            } else if (abstractEmployee.getType().equals(EmployeeEnum.SALES)) {

            } else if (abstractEmployee.getType().equals(EmployeeEnum.MANAGER)) {
                Manager manager = new Manager();
                salarySub = manager.getSalary(abstractEmployee, date);


            }
        }

        return salarySub.setScale(2, RoundingMode.HALF_UP);

    }

    /*BigDecimal calculateManagerSubSalary(Manager employee, LocalDate date, BigDecimal percentSub) {
     *//* AbstractEmployee abstractEmployee = list.get(list.size() - 1);
        salarySub = salarySub.add(calculateSalaryOneEmployee(abstractEmployee, date, percent));
        list.remove(abstractEmployee);
        if (list.size() > 0) {
            calculateManagerSubSalary(list, date, percent);
        }
        return salarySub;*//*
        ManagerService service = new ManagerService();
        BigDecimal baseSalaryManager = calculateSalaryWithPercent(employee, service.PERCENT, service.MAX, date);
*//*

        for (int i = 0; i < employee.getSubordinates().size(); i++) {
            AbstractEmployee sub = (AbstractEmployee) employee.getSubordinates().get(i);
*//*
        for (AbstractEmployee sub : employee.getSubordinates()) {
            salarySub = salarySub.add(calculateSalaryOneEmployee(sub, date));
            *//*if (!sub.getType().equals(EmployeeEnum.MANAGER))
                salarySub = salarySub.add(calculateSalaryOneEmployee(sub, date));
            else {
              calculateManagerSubSalary((Manager) sub, date, percentSub);
            }*//*
        }
        return baseSalaryManager.add(salarySub.multiply(percentSub)).setScale(2,  RoundingMode.HALF_UP );
    }
*/

}





