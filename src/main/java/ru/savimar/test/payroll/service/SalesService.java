package ru.savimar.test.payroll.service;

import ru.savimar.test.payroll.model.AbstractEmployee;
import ru.savimar.test.payroll.model.EmployeeEnum;
import ru.savimar.test.payroll.model.Sales;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

public class SalesService extends AbstractEmployeeService implements IAbstractEmployeeService<Sales> {

    private final BigDecimal PERCENT = new BigDecimal(0.01).setScale(2, RoundingMode.HALF_UP);
    private final BigDecimal MAX = new BigDecimal(0.35).setScale(2, RoundingMode.HALF_UP);

    private final BigDecimal PERCENT_SUBORDINATES = new BigDecimal(0.003).setScale(3, RoundingMode.HALF_EVEN);

    @Override
    public BigDecimal calculateSalary(Sales employee, LocalDate date) {
        BigDecimal baseSalaryManager = calculateSalaryWithPercent(employee, PERCENT, MAX, date);
        //   salarySub = salarySub.add(calculateSalaryAllSubordinates(employee.getSubordinates(), date));
        return baseSalaryManager.add(salarySub);
    }


    private BigDecimal calculateSalaryAllSubordinates(List<AbstractEmployee> list, LocalDate date) {

        AbstractEmployee employee = list.get(list.size() - 1);
        if (employee.getType().equals(EmployeeEnum.SALES)) {

        } else {
            /*salarySub = salarySub.add(calculateSalaryOneEmployee(employee, date, PERCENT_SUBORDINATES));
            list.remove(employee);
            if (list.size() > 0) {
                calculateSalaryAllSubordinates(list, date);
            }*/
        }
        return salarySub;
    }


}
