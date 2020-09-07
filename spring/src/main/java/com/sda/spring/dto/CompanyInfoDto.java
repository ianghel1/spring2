package com.sda.spring.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CompanyInfoDto {

    private Integer id;

    private String name;

    private String adress;

    private String phoneNumberCompany;

    private Long registrationNumber;

    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<EmployeeSummaryDto> employeeList;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumberCompany() {
        return phoneNumberCompany;
    }

    public void setPhoneNumberCompany(String phoneNumberCompany) {
        this.phoneNumberCompany = phoneNumberCompany;
    }

    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<EmployeeSummaryDto> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<EmployeeSummaryDto> employeeList) {
        this.employeeList = employeeList;
    }
}
