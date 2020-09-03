package com.sda.spring.service;

import com.sda.spring.dto.SalaryCreateDto;
import com.sda.spring.dto.SalaryInfoDto;
import com.sda.spring.model.Salary;

import java.util.List;

public interface SalaryService {

    SalaryInfoDto create(SalaryCreateDto salary);

    List<Salary> saveAll(List<Salary> salaryList);

    Salary getById(Integer id);

    List<Salary> getByValue(Double value);

    List<Salary> getAll(Integer pageNo, Integer pageSize, String sortBy);
}
