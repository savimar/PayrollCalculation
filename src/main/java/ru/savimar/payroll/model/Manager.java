package ru.savimar.payroll.model;


import ru.savimar.payroll.service.IAbstractEmployeeService;
import ru.savimar.payroll.service.ManagerService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public class Manager extends AbstractEmployee {

    public Manager() {
        super();
        super.setType(EmployeeEnum.MANAGER);
    }

    public Manager(LocalDate employmentDate, List<AbstractEmployee> employees) {
        this();
        super.setEmploymentDate(employmentDate);
        super.setSubordinates(employees);
    }

    @Override
    public BigDecimal getSalary(AbstractEmployee employee, LocalDate date) {
        IAbstractEmployeeService<Manager> service = new ManagerService();
        if (employee.getType().equals(EmployeeEnum.MANAGER)) {
            return service.calculateSalary((Manager) employee, date);
        }
        return BigDecimal.ZERO;
    }


}
