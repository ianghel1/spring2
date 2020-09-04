package com.sda.spring.dto;

import javax.validation.constraints.*;

public class SalaryCreateDto {

    @Min(500)
    @Max(2000)
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
