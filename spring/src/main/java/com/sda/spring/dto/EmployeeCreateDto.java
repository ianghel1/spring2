package com.sda.spring.dto;

import com.sda.spring.model.Company;
import com.sda.spring.model.Project;
import com.sda.spring.model.Salary;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmployeeCreateDto {

    //aici  nu avem nevoie de id, deoarece acesta se genereaza in baza de date, nu in aplicatie
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String email;

    @NotEmpty
    private String address;

    @NotEmpty
    private String phoneNumber;

    @NotNull
    private Long personalNumericCode;


    private boolean isHired;

    private Salary salary;



    public boolean isHired() {
        return isHired;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getPersonalNumericCode() {
        return personalNumericCode;
    }

    public void setPersonalNumericCode(Long personalNumericCode) {
        this.personalNumericCode = personalNumericCode;
    }

    public boolean getHired() {
        return isHired;
    }

    public void setHired(boolean hired) {
        isHired = hired;
    }

}
