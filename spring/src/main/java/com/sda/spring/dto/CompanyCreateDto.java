package com.sda.spring.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class CompanyCreateDto {


  //aici  nu avem nevoie de id, deoarece acesta se genereaza in baza de date, nu in aplicatie

    @NotEmpty
    private String name;

    @NotEmpty
    private String adress;

    @NotEmpty
    private String phoneNumberCompany;

    @NotNull
    // @Min(value=100000000)
    private Long registrationNumber;

    @NotBlank
    private String email;



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
}
