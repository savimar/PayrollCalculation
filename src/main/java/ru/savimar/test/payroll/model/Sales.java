package ru.savimar.test.payroll.model;


import ru.savimar.test.payroll.service.SalesService;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Sales extends AbstractEmployee {

    public Sales() {
        super();
        super.setType(EmployeeEnum.SALES);
    }


    @Override
    public BigDecimal getSalary(AbstractEmployee employee, LocalDate date) {
        SalesService service = new SalesService();
        if (employee.getType().equals(EmployeeEnum.SALES)) {
            return service.calculateSalary((Sales) employee, date);
        }
        return BigDecimal.ZERO;
    }
}
