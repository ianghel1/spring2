package com.sda.spring.service;

import com.sda.spring.model.Salary;

import java.util.List;

public interface SalaryService {

    Salary create(Salary salary);

    List<Salary> saveAll(List<Salary> salaryList);

    Salary getById(Integer id);

    List<Salary> getAll(Integer pageNo, Integer pageSize, String sortBy);
}
