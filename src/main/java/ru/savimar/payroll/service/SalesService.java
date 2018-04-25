package ru.savimar.payroll.service;


import ru.savimar.payroll.model.AbstractEmployee;
import ru.savimar.payroll.model.Sales;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class SalesService extends AbstractEmployeeService implements IAbstractEmployeeService<Sales> {

    private final BigDecimal PERCENT = new BigDecimal(0.01).setScale(2, RoundingMode.HALF_UP);
    private final BigDecimal MAX = new BigDecimal(0.35).setScale(2, RoundingMode.HALF_UP);
    private final BigDecimal PERCENT_SUBORDINATES = new BigDecimal(0.003).setScale(3, RoundingMode.HALF_EVEN);

    private Set<List<AbstractEmployee>> subSubordinates =  new LinkedHashSet<>() ;

    @Override
    public BigDecimal calculateSalary(Sales employee, LocalDate date) {
        BigDecimal baseSalaryManager = calculateSalaryWithPercent(employee, PERCENT, MAX, date);

        salarySub = calculateSalaryAllSubordinates(employee.getSubordinates(), date);
        salarySub = salarySub.multiply(PERCENT_SUBORDINATES);

        return baseSalaryManager.add(salarySub).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateSalaryAllSubordinates(List<AbstractEmployee> list, LocalDate date) {

         for (AbstractEmployee employee : list) {
          salarySub = calculateSalaryOneEmployee(employee, date);
            List<AbstractEmployee> subordinates = employee.getSubordinates();
            if (subordinates != null && subordinates.size() > 0) {
                calculateSalaryAllSubordinates(subordinates, date);
            }
        }
       /* subSubordinates.add(list);
        getSalarySubSubordinates(date);
        subSubordinates.remove(list);
        if(subSubordinates.size()>0){
            getSalarySubSubordinates(date);
        }*/


        return salarySub.setScale(2, RoundingMode.HALF_UP);
    }

   /* private void getSalarySubSubordinates(LocalDate date) {
        for (List<AbstractEmployee> employees : subSubordinates) {
            for (AbstractEmployee employee : employees) {
                salarySub = calculateSalaryOneEmployee(employee, date);
                List<AbstractEmployee> subordinates = employee.getSubordinates();
                if (subordinates != null && subordinates.size() > 0) {
                    subSubordinates.add(subordinates);
                }
              }
        }
    }*/

}
