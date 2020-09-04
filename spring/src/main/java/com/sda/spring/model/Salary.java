package com.sda.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "salary")
public class Salary {
    //    /Salary:
//private Integer id;
//private Double value;
//private String currency;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Double value;

    @Column
    private String currency;

    @OneToOne(
            mappedBy = "salary",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false)
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
