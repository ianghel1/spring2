package com.sda.spring.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmployeeCreateDto {

@NotBlank
    private String firstName;

@NotBlank
    private String lastName;

@NotBlank
    private String email;

@NotBlank
    private String address;

@NotBlank
    private String phoneNumber;

@NotNull
    private Long personalNumericCode;

@NotNull
    private Boolean isHired;

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

    public Boolean getHired() {
        return isHired;
    }

    public void setHired(Boolean hired) {
        isHired = hired;
    }
}
