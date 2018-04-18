package ru.savimar.test.payroll.service;

import ru.savimar.test.payroll.model.AbstractEmployee;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface IAbstractEmployeeService <T extends AbstractEmployee>{


   BigDecimal calculateSalary( T employee,  LocalDate date);

}

