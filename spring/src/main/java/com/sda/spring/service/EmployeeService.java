package com.sda.spring.service;

import com.sda.spring.model.Employee;

import java.util.List;

public interface EmployeeService{

    Employee create(Employee employee);

    Employee getById(Integer id);

    List<Employee> getAll();

}
