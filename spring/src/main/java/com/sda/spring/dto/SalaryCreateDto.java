package com.sda.spring.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SalaryCreateDto {

    @NotNull
    private Double value;

    @NotBlank
    private String currency;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
