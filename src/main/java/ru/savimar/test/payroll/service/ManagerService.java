package ru.savimar.test.payroll.service;

import ru.savimar.test.payroll.model.AbstractEmployee;
import ru.savimar.test.payroll.model.EmployeeEnum;
import ru.savimar.test.payroll.model.Manager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

public class ManagerService extends AbstractEmployeeService implements IAbstractEmployeeService<Manager> {

    private final BigDecimal PERCENT = new BigDecimal(0.05).setScale(2, RoundingMode.HALF_UP);
    private final BigDecimal MAX = new BigDecimal(0.4).setScale(2, RoundingMode.HALF_UP);

    private final BigDecimal PERCENT_SUBORDINATES = new BigDecimal(0.005).setScale(3, RoundingMode.HALF_EVEN);


    @Override
    public BigDecimal calculateSalary(Manager employee, LocalDate date/*, List<AbstractEmployee> subordinates*/) {
        BigDecimal baseSalaryManager = calculateSalaryWithPercent(employee, PERCENT, MAX, date);
        BigDecimal salarySub = calculateSalaryAllSubordinates(employee.getSubordinates(), date, PERCENT_SUBORDINATES);

        return baseSalaryManager.add(salarySub);
    }

    private BigDecimal calculateSalaryAllSubordinates(List<AbstractEmployee> list, LocalDate date, BigDecimal percent) {
        for (AbstractEmployee abstractEmployee : list) {
            if (abstractEmployee.getType().equals(EmployeeEnum.MANAGER)) {

            } else {
                salarySub = salarySub.add(calculateSalarySubordinates(abstractEmployee, date, PERCENT_SUBORDINATES));
            }
        }

        return salarySub.multiply(percent).setScale(2, RoundingMode.HALF_UP);

    }
}
