package com.sda.spring.service;

import com.sda.spring.dto.EmployeeCreateDto;
import com.sda.spring.dto.EmployeeInfoDto;
import com.sda.spring.model.Employee;

import javax.validation.Valid;
import java.util.List;

public interface EmployeeService {
    EmployeeInfoDto create(@Valid EmployeeCreateDto employeeInfoDto);

    List<Employee> saveAll(List<Employee> employeeList);

    EmployeeInfoDto getById(Integer id);

    EmployeeInfoDto getById2(Integer id);

    List<Employee> getByName(String firstName, String lastName);

    List<Employee> getAll(Integer pageNo, Integer pageSize, String sortBy);
}
