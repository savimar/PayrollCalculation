package ru.savimar.payroll.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public abstract class AbstractEmployee {
    public final BigDecimal BASE_PAYROLL = BigDecimal.valueOf(2000000L, 2);
    //TODO get from config

    private Long id;
    private String name;
    private LocalDate employmentDate;
    private EmployeeEnum type;
    private List<AbstractEmployee> subordinates;

    public List<AbstractEmployee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<AbstractEmployee> subordinates) {
        this.subordinates = subordinates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public EmployeeEnum getType() {
        return type;
    }

    public void setType(EmployeeEnum type) {
        this.type = type;
    }

    public abstract BigDecimal getSalary(AbstractEmployee employee, LocalDate date);
}
