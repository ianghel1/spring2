package com.sda.spring.service.impl;

import com.sda.spring.dto.EmployeeCreateDto;
import com.sda.spring.dto.EmployeeInfoDto;
import com.sda.spring.exception.EmployeeNotFoundException;
import com.sda.spring.model.Employee;
import com.sda.spring.repository.EmployeeRepository;
import com.sda.spring.service.EmployeeService;
import org.modelmapper.ModelMapper;
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

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper){
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeInfoDto create(EmployeeCreateDto employeeCreateDto) {
        Employee entity = modelMapper.map(employeeCreateDto, Employee.class);
        Employee resultAfterSave = employeeRepository.save(entity);

        EmployeeInfoDto response = modelMapper.map(resultAfterSave, EmployeeInfoDto.class);
        return response;

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
