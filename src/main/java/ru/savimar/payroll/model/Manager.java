package ru.savimar.payroll.model;


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

}
