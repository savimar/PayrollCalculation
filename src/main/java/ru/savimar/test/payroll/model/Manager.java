package ru.savimar.test.payroll.model;

import ru.savimar.test.payroll.model.util.EmployeeCollection;

import java.util.List;

public class Manager extends AbstractEmployee{

    public Manager() {
        super();
        super.setType(EmployeeEnum.MANAGER);
    }

    private EmployeeCollection subordinates;

    public EmployeeCollection getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(EmployeeCollection subordinates) {
        this.subordinates = subordinates;
    }
}
