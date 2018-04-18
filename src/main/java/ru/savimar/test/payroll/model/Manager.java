package ru.savimar.test.payroll.model;


import ru.savimar.test.payroll.service.ManagerService;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Manager extends AbstractEmployee {

    public Manager() {
        super();
        super.setType(EmployeeEnum.MANAGER);
    }


    @Override
    public BigDecimal getSalary(AbstractEmployee employee, LocalDate date) {
        ManagerService service = new ManagerService();
        if (employee.getType().equals(EmployeeEnum.MANAGER)) {
            return service.calculateSalary((Manager) employee, date);
        }
        return BigDecimal.ZERO;
    }
}
