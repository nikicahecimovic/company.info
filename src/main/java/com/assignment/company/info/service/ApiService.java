package com.assignment.company.info.service;

import com.assignment.company.info.model.Department;
import com.assignment.company.info.model.Employee;
import com.assignment.company.info.repository.DepartmentRepository;
import com.assignment.company.info.repository.EmployeeRepository;
import com.assignment.company.info.request.CreateDepartmentRequest;
import com.assignment.company.info.request.CreateEmployeeRequest;
import com.assignment.company.info.request.UpdateEmployeeRequest;
import com.assignment.company.info.response.DepartmentResponse;
import com.assignment.company.info.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    @Autowired
    public ApiService (EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<EmployeeResponse> getEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee ->{
                EmployeeResponse response = new EmployeeResponse();
                response.setId(employee.getId());
                response.setFirstName(employee.getFirstName());
                response.setLastName(employee.getLastName());
                response.setGender(employee.getGender());
                response.setImageUrl(employee.getImageUrl());
                response.setYearOfBirth(employee.getYearOfBirth());
                if (employee.getDepartment() != null) {
                    response.setDepartmentId(employee.getDepartment().getId());
                }
                response.setContractLength(employee.getContractLength());
                response.setContractType(employee.getContractType());
                response.setStartDate(employee.getStartDate());
                response.setAmountOfDaysOff(employee.getAmountOfDaysOff());
                response.setAmountOfPaidLeave(employee.getAmountOfPaidLeave());
                response.setAmountOfVacationDays(employee.getAmountOfVacationDays());
                return response;
        }).collect(Collectors.toList());
    }

    public void addEmployee(CreateEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setGender(request.getGender());
        employee.setImageUrl(request.getImageUrl());
        employee.setYearOfBirth(request.getYearOfBirth());
        employee.setContractLength(request.getContractLength());
        employee.setContractType(employee.getContractType());
        employee.setStartDate(employee.getStartDate());
        employee.setAmountOfDaysOff(employee.getAmountOfDaysOff());
        employee.setAmountOfPaidLeave(employee.getAmountOfPaidLeave());
        employee.setAmountOfVacationDays(employee.getAmountOfVacationDays());
        employeeRepository.save(employee);
    }



    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    public void editEmployee(Long id, UpdateEmployeeRequest request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("No Employee found with ID = %d", id)));
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setGender(request.getGender());
        employee.setImageUrl(request.getImageUrl());
        employee.setYearOfBirth(request.getYearOfBirth());
        employee.setContractLength(request.getContractLength());
        employee.setContractType(request.getContractType());
        employee.setStartDate(request.getStartDate());
        employee.setAmountOfDaysOff(request.getAmountOfDaysOff());
        employee.setAmountOfPaidLeave(request.getAmountOfPaidLeave());
        employee.setAmountOfVacationDays(request.getAmountOfVacationDays());
        employeeRepository.save(employee);
    }

    public List<DepartmentResponse> getDepartments() {
        List<Department> departmentList = departmentRepository.findAll();
        return departmentList.stream().map(department -> {
            DepartmentResponse departmentResponse= new DepartmentResponse();
            departmentResponse.setId(department.getId());
            departmentResponse.setEmployeeList(department.getEmployees().stream()
                    .map(Employee::getId).collect(Collectors.toList()));
        return departmentResponse;
        }).collect(Collectors.toList());
    }

    public void addDepartment() {
        Department department = new Department();
        departmentRepository.save(department);
    }

    public void addEmployeeToDepartment(Long departmentId, Long employeeId){
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalStateException(String.format("No Department found with ID = %d", departmentId)));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException(String.format("No Employee found with ID = %d", employeeId)));

        List<Employee> employeeList = department.getEmployees();
        employeeList.add(employee);
        department.setEmployees(employeeList);
        departmentRepository.save(department);
    }

    public void removeEmployeeFromDepartment(Long departmentId, Long employeeId){
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalStateException(String.format("No Department found with ID = %d", departmentId)));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException(String.format("No Employee found with ID = %d", employeeId)));

        List<Employee> employeeList = department.getEmployees();
        employeeList.remove(employee);
        department.setEmployees(employeeList);
        departmentRepository.save(department);
    }

    public void addDepartmentToEmployee(Long departmentId, Long employeeId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalStateException(String.format("No Department found with ID = %d", departmentId)));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException(String.format("No Employee found with ID = %d", employeeId)));

        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    public void removeDepartmentFromEmployee(Long departmentId, Long employeeId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalStateException(String.format("No Department found with ID = %d", departmentId)));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException(String.format("No Employee found with ID = %d", employeeId)));

        employee.setDepartment(department);
        employeeRepository.save(employee);

    }
}
