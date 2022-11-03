package com.assignment.company.info.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String imageUrl;
    @Column
    private Gender gender;
    @Column
    private int yearOfBirth;
    @Column
    private LocalDateTime startDate;
    @Column
    private ContractType contractType;
    @Column
    private int contractLength;
    @ManyToOne
    private Department department;
    @Column
    private int amountOfVacationDays;
    @Column
    private int amountOfDaysOff;
    @Column
    private int amountOfPaidLeave;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
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

    public enum ContractType {
        FIXED,
        INDEFINITE
    }
    public enum Gender {
        MALE,
        FEMALE
    }
}
