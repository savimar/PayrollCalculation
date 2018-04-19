package ru.savimar.test.payroll.model;


import ru.savimar.test.payroll.service.EmployeeService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Employee extends AbstractEmployee {
    private List<AbstractEmployee> list;

    public Employee() {
        super();
        super.setType(EmployeeEnum.EMPLOYEE);
        list = List.of();
        list = Collections.unmodifiableList(list);
        super.setSubordinates(list);
    }
    public Employee(LocalDate employmentDate){
        this();
        super.setEmploymentDate(employmentDate);
    }


    @Override
    public BigDecimal getSalary(AbstractEmployee employee, LocalDate date) {
        EmployeeService service = new EmployeeService();
        if (employee.getType().equals(EmployeeEnum.EMPLOYEE)) {
            return service.calculateSalary((Employee) employee, date);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void setSubordinates(List<AbstractEmployee> subordinates) {
        super.setSubordinates(list);
    }

    @Override
    public List<AbstractEmployee> getSubordinates() {
        return null;
    }
}
