package com.sda.spring.service.impl;

import com.sda.spring.dto.*;
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


    // @Autowired - dupa ce facem contructorul nu mai este nevoie de autowired
    private final EmployeeRepository employeeRepository;

    //@Autowired
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeInfoDto create(EmployeeCreateDto employeeCreateDto) {
        Employee entity = modelMapper.map(employeeCreateDto, Employee.class);
        Employee resultAfterSave = employeeRepository.save(entity);

        EmployeeInfoDto response = modelMapper.map(resultAfterSave, EmployeeInfoDto.class);

        response.setCompanySummaryDto(modelMapper.map(resultAfterSave.getCompany(), CompanySummaryDto.class));
        response.setSalarySummaryDto(modelMapper.map(resultAfterSave.getSalary(), SalarySummaryDto.class));
//todo make Employee able to have project
        return response;
    }

    @Override
    public List<Employee> saveAll(List<Employee> employeeList) {

        return (List<Employee>) employeeRepository.saveAll(employeeList);
    }

    /** Varianta 1: folosim typeMap pentru ca lega CompanySummaryDto la EmployeeInfoDto*/
    @Override
    public EmployeeInfoDto getById(Integer id) {
        Optional<Employee> foundEmployee = employeeRepository.findById(id);

        //Configure modelMapper to map the Company to the Employee
        modelMapper.typeMap(Employee.class, EmployeeInfoDto.class)
                .addMappings(mapper -> mapper.map(Employee::getCompany, EmployeeInfoDto::setCompanySummaryDto));

        return foundEmployee.map(entity -> modelMapper.map(entity, EmployeeInfoDto.class))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found!"));
    }

    /** Varianta 2: adaugam manual / programatic CompanySummeryDto la EmployeeInfoDto*/
    @Override
    public EmployeeInfoDto getById2(Integer id) {
        Optional<Employee> foundEmployee = employeeRepository.findById(id);

        EmployeeInfoDto result = foundEmployee.map(entity -> modelMapper.map(entity, EmployeeInfoDto.class))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found!"));

        result.setCompanySummaryDto(modelMapper.map(foundEmployee.get().getCompany(), CompanySummaryDto.class));
        return result;
    }

    @Override
    public List<Employee> getByName(String firstName, String lastName) {
        List<Employee> results = employeeRepository.findAllByFirstNameAndLastName(firstName, lastName);

        if (results.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with first name and last name " + firstName + " " + lastName + " not found");
        }

        return results;
    }

    @Override
    public List<Employee> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Employee> pageResult = employeeRepository.findAll(pageable);  // alegem findAll de tip pageable
        return pageResult.getContent(); //ne da rezultatul din pageresult, adica lista de employee
    }
}
