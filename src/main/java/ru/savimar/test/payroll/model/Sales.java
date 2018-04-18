package ru.savimar.test.payroll.model;

import ru.savimar.test.payroll.model.util.EmployeeCollection;



public class Sales extends AbstractEmployee {

   private EmployeeCollection subordinates;

    public Sales() {
        super();
        super.setType(EmployeeEnum.SALES);
    }

    public EmployeeCollection getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(EmployeeCollection subordinates) {
        this.subordinates = subordinates;
    }
}
