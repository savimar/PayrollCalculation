package ru.savimar.payroll.service;

import ru.savimar.payroll.model.AbstractEmployee;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface IAbstractEmployeeService {

    BigDecimal calculateSalary(AbstractEmployee employee, LocalDate date);

    }

