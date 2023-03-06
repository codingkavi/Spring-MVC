package com.gdm.training.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.*;

public class Employee {

    @NotNull(message = "please provide valid id")
    @Min(100)
    private int id;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotNull(message = "please provide salary")
    @Min(100L)
    @Max(10000L)
    private int salary;

    public Employee() {
    }

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
