package com.assignment.company.info.request;

import com.assignment.company.info.model.Employee;

import java.util.List;

public class CreateDepartmentRequest {

    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
