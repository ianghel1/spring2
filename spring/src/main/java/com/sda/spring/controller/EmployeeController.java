package com.sda.spring.controller;

import com.sda.spring.components.CustomFaker;
import com.sda.spring.dto.EmployeeCreateDto;
import com.sda.spring.dto.EmployeeInfoDto;
import com.sda.spring.model.Employee;
import com.sda.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/employees")
@ControllerAdvice
public class EmployeeController {

    private EmployeeService employeeService;
    private CustomFaker customFaker;

    @Autowired
    public EmployeeController(EmployeeService employeeService, CustomFaker customFaker){
        this.employeeService = employeeService;
        this.customFaker = customFaker;
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeInfoDto> create(@RequestBody  EmployeeCreateDto employeeCreateDto) {
        return ResponseEntity.ok(employeeService.create(employeeCreateDto));
    }

    @GetMapping("/getById")
    public ResponseEntity<Employee> getById(@RequestParam Integer id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(employeeService.getAll(pageNo, pageSize, sortBy));
    }

    @GetMapping("/populate")
    public void faker() {
        employeeService.saveAll(customFaker.createDummyEmployeeList());
    }


    @GetMapping("/findByName")
    public ResponseEntity<List<Employee>> getByName(
            @RequestParam String firstName,
            @RequestParam String lastName) {

        return ResponseEntity.ok(employeeService.getByName(firstName, lastName));
    }


}
