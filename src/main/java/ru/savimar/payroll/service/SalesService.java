package ru.savimar.payroll.service;



import ru.savimar.payroll.model.AbstractEmployee;
import ru.savimar.payroll.model.Sales;

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

        salarySub = calculateSalaryAllSubordinates(employee.getSubordinates(), date);
        salarySub = salarySub.multiply(PERCENT_SUBORDINATES);

        return baseSalaryManager.add(salarySub).setScale(2, RoundingMode.HALF_UP);
    }


    private BigDecimal calculateSalaryAllSubordinates(List<AbstractEmployee> list, LocalDate date) {
        if (list.size() > 0) {
            AbstractEmployee employee = list.get(list.size() - 1);

            salarySub = calculateSalaryOneEmployee(employee, date);

            List<AbstractEmployee> subSubordinates = employee.getSubordinates();
            if (subSubordinates != null && subSubordinates.size() > 0) {
                calculateSalaryAllSubordinates(subSubordinates, date);
            }
            list.remove(employee);
            if (list.size() > 0) {
                calculateSalaryAllSubordinates(list, date);
            }

            return salarySub.setScale(2, RoundingMode.HALF_UP);
        }
        return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    }


}