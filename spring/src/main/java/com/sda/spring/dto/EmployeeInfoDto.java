package com.sda.spring.dto;

import com.sda.spring.model.Project;

import java.util.List;

public class EmployeeInfoDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String phoneNumber;

    private Long personalNumericCode;

    private Boolean isHired;

    private CompanySummaryDto companySummaryDto;

    private SalarySummaryDto salarySummaryDto;

    private List<ProjectSummaryDto> projects;

    public List<ProjectSummaryDto> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectSummaryDto> projects) {
        this.projects = projects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {    this.id = id;    }

    public String getFirstName() {   return firstName;   }

    public void setFirstName(String firstName) {     this.firstName = firstName;    }

    public String getLastName() {        return lastName;    }

    public void setLastName(String lastName) {        this.lastName = lastName;    }

    public String getEmail() {        return email;    }

    public void setEmail(String email) {        this.email = email;    }

    public String getAddress() {        return address;    }

    public void setAddress(String address) {        this.address = address;    }

    public String getPhoneNumber() {        return phoneNumber;    }

    public void setPhoneNumber(String phoneNumber) {    this.phoneNumber = phoneNumber;    }

    public Long getPersonalNumericCode() {        return personalNumericCode;    }

    public void setPersonalNumericCode(Long personalNumericCode) {        this.personalNumericCode = personalNumericCode;    }

    public Boolean getHired() {        return isHired;    }

    public void setHired(Boolean hired) {        isHired = hired;    }

    public CompanySummaryDto getCompanySummaryDto() {
        return companySummaryDto;
    }

    public void setCompanySummaryDto(CompanySummaryDto companySummaryDto) {
        this.companySummaryDto = companySummaryDto;
    }

    public SalarySummaryDto getSalarySummaryDto() {
        return salarySummaryDto;
    }

    public void setSalarySummaryDto(SalarySummaryDto salarySummaryDto) {
        this.salarySummaryDto = salarySummaryDto;
    }
}
