package com.assignment.company.info.response;

import java.util.List;

public class DepartmentResponse {
    private Long id;
    private List<Long> employeeList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Long> employeeList) {
        this.employeeList = employeeList;
    }
}
