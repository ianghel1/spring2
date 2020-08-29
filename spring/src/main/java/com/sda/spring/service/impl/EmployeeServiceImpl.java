package com.sda.spring.service.impl;

import com.sda.spring.model.Employee;
import com.sda.spring.repository.EmployeeRepository;
import com.sda.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getById(Integer id) {
        Optional<Employee> foundEmployee =  employeeRepository.findById(id);

        return foundEmployee.get();
    }

    @Override
    public List<Employee> getAll() {

        return (List<Employee>) employeeRepository.findAll();
    }
}
