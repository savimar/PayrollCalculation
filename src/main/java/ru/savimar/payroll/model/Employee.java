package ru.savimar.payroll.model;


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

    public Employee(LocalDate employmentDate) {
        this();
        super.setEmploymentDate(employmentDate);
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
