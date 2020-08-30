package com.sda.spring.service;

import com.sda.spring.model.Employee;

import java.util.List;

public interface EmployeeService{

    Employee create(Employee employee);

    List<Employee> saveAll(List<Employee> employeeList);

    Employee getById(Integer id);


    List<Employee> getByName(String firstName, String lastName);

    List<Employee> getAll(Integer pageNo, Integer pageSize, String sortBy);

}
