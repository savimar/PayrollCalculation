package ru.savimar.test.payroll.service;

import org.junit.Before;
import ru.savimar.test.payroll.model.AbstractEmployee;
import ru.savimar.test.payroll.model.Employee;
import ru.savimar.test.payroll.model.Manager;
import ru.savimar.test.payroll.model.Sales;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

public class TestData {

    static final Employee EMPLOYEE1 = new Employee(LocalDate.of(2007, 2, 6));
    static final BigDecimal EMPLOYEE1_SALARY = BigDecimal.valueOf(26000.00).setScale(2, RoundingMode.HALF_UP);
    static final Employee EMPLOYEE2 = new Employee(LocalDate.of(2015, 1, 25));
    static final BigDecimal EMPLOYEE2_SALARY = BigDecimal.valueOf(21800.00).setScale(2, RoundingMode.HALF_UP);

    static final List<AbstractEmployee> EMPLOYEES = List.of(EMPLOYEE1, EMPLOYEE2);


    static final Employee EMPLOYEE3 = new Employee(LocalDate.of(2014, 4, 19));
    static final Employee EMPLOYEE4 = new Employee(LocalDate.of(2018, 1, 25));


    static final Manager MANAGER1 = new Manager(LocalDate.of(2014, 5, 28), EMPLOYEES);
    static final List<AbstractEmployee> EMPLOYEES1 = List.of(EMPLOYEE3, EMPLOYEE4, MANAGER1);

    static final Sales SALES1 = new Sales(LocalDate.of(2012, 9, 15), EMPLOYEES1);

    static final List<AbstractEmployee> EMPLOYEES2 = List.of(EMPLOYEE2, SALES1, MANAGER1);

    static final Manager MANAGER2 = new Manager(LocalDate.of(2017, 3, 14), EMPLOYEES2);

    static final List<AbstractEmployee> EMPLOYEES3 = List.of(EMPLOYEE4, SALES1, MANAGER2);

    static final Sales SALES2 = new Sales(LocalDate.of(2018, 3, 22), EMPLOYEES3);


    @Before
    public void setUp() throws Exception {


    }

}
