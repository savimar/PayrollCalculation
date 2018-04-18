package ru.savimar.test.payroll.model;

public class Employee extends AbstractEmployee {

    public Employee() {
        super();
        super.setType(EmployeeEnum.EMPLOYEE);
    }
}
