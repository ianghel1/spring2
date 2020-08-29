package com.sda.spring.controller;

import com.sda.spring.components.CustomFaker;
import com.sda.spring.model.Employee;
import com.sda.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomFaker customFaker;

    @PostMapping("/save")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.create(employee));
    }

    @GetMapping("/getById")
    public ResponseEntity<Employee> getById(@RequestParam Integer id){
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/populate")
    public void faker(){
        employeeService.saveAll(customFaker.createDummyEmployeeList());
    }


}
