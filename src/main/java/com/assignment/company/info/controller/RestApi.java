package com.assignment.company.info.controller;

import com.assignment.company.info.model.Department;
import com.assignment.company.info.model.Employee;
import com.assignment.company.info.request.CreateEmployeeRequest;
import com.assignment.company.info.request.UpdateEmployeeRequest;
import com.assignment.company.info.response.DepartmentResponse;
import com.assignment.company.info.response.EmployeeResponse;
import com.assignment.company.info.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestApi {

    @Autowired
    ApiService apiService;

    @GetMapping(value = "employee/employees")
    public List<EmployeeResponse> getEmployees() {
       return apiService.getEmployees();
    }

    @PostMapping(value = "employee/add")
    public void addEmployee(@RequestBody CreateEmployeeRequest request) {
        apiService.addEmployee(request);
    }

    @PutMapping(value = "employee/edit/{id}")
    public void editEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeRequest request) {
        apiService.editEmployee(id, request);
    }

    @DeleteMapping(value = "employee/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        apiService.deleteEmployee(id);
    }

    @GetMapping(value = "department/departments")
    public List<DepartmentResponse> getDepartments() {
        return apiService.getDepartments();
    }

    @PostMapping(value = "department/add")
    public void addDepartment() {
        apiService.addDepartment();
    }

    @PutMapping(value = "department/addEmployee/{departmentId}/{employeeId}")
    public void addEmployeeToDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        apiService.addEmployeeToDepartment(departmentId, employeeId);
    }

    @PutMapping(value = "department/removeEmployee/{departmentId}/{employeeId}")
    public void removeEmployeeFromDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        apiService.removeDepartmentFromEmployee(departmentId, employeeId);
    }

    @PutMapping(value = "employee/addDepartment/{departmentId}/{employeeId}")
    public void addDepartmentToEmployee(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        apiService.addDepartmentToEmployee(departmentId, employeeId);
    }

    @PutMapping(value = "employee/removeDepartment/{departmentId}/{employeeId}")
    public void removeDepartmentFromEmployee(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        apiService.removeDepartmentFromEmployee(departmentId, employeeId);
    }


}
