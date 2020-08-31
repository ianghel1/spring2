package com.sda.spring.service.impl;

import com.sda.spring.exception.EmployeeNotFoundException;
import com.sda.spring.model.Employee;
import com.sda.spring.repository.EmployeeRepository;
import com.sda.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<Employee> saveAll(List<Employee> employeeList) {

        return (List<Employee>) employeeRepository.saveAll(employeeList);
    }

    @Override
    public Employee getById(Integer id) {
        Optional<Employee> foundEmployee = employeeRepository.findById(id);

        return foundEmployee.get();
    }

    @Override
    public List<Employee> getByName(String firstName, String lastName) {
        List<Employee> results = employeeRepository.findAllByFirstNameAndLastName(firstName, lastName);


        if (results.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with " + firstName + " " + lastName + " not found.");
        }

        return results;
    }


    @Override
    public List<Employee> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Employee> pageResult = employeeRepository.findAll(pageable);
        return pageResult.getContent();
    }
}
