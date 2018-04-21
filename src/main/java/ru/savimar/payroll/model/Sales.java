package ru.savimar.payroll.model;


import java.time.LocalDate;
import java.util.List;


public class Sales extends AbstractEmployee {

    public Sales() {
        super();
        super.setType(EmployeeEnum.SALES);
    }

    public Sales(LocalDate employmentDate, List<AbstractEmployee> employees) {
        this();
        super.setEmploymentDate(employmentDate);
        super.setSubordinates(employees);
    }

}
