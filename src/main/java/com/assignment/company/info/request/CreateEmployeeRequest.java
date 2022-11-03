package com.assignment.company.info.request;

import com.assignment.company.info.model.Department;
import com.assignment.company.info.model.Employee;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class CreateEmployeeRequest {
    private String firstName;

    private String lastName;

    private String imageUrl;

    private Employee.Gender gender;

    private int yearOfBirth;

    private LocalDateTime startDate;

    private Employee.ContractType contractType;

    private int contractLength;

    private Department department;

    private int amountOfVacationDays;

    private int amountOfDaysOff;

    private int amountOfPaidLeave;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Employee.Gender getGender() {
        return gender;
    }

    public void setGender(Employee.Gender gender) {
        this.gender = gender;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Employee.ContractType getContractType() {
        return contractType;
    }

    public void setContractType(Employee.ContractType contractType) {
        this.contractType = contractType;
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(int contractLength) {
        this.contractLength = contractLength;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getAmountOfVacationDays() {
        return amountOfVacationDays;
    }

    public void setAmountOfVacationDays(int amountOfVacationDays) {
        this.amountOfVacationDays = amountOfVacationDays;
    }

    public int getAmountOfDaysOff() {
        return amountOfDaysOff;
    }

    public void setAmountOfDaysOff(int amountOfDaysOff) {
        this.amountOfDaysOff = amountOfDaysOff;
    }

    public int getAmountOfPaidLeave() {
        return amountOfPaidLeave;
    }

    public void setAmountOfPaidLeave(int amountOfPaidLeave) {
        this.amountOfPaidLeave = amountOfPaidLeave;
    }
}
