package com.sda.spring.controller;


import com.sda.spring.components.CustomFaker;
import com.sda.spring.model.Salary;
import com.sda.spring.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salary")
@ControllerAdvice
public class SalaryController {

    private SalaryService salaryService;
    private CustomFaker customFaker;

    @Autowired
    public SalaryController(SalaryService salaryService, CustomFaker customFaker) {
        this.salaryService = salaryService;
        this.customFaker = customFaker;
    }


    @PostMapping("/save")
    public ResponseEntity<Salary> create(@RequestBody Salary salary) {
        return ResponseEntity.ok(salaryService.create(salary));
    }

    @GetMapping("/getById")
    public ResponseEntity<Salary> getById(@RequestParam Integer id) {
        return ResponseEntity.ok(salaryService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Salary>> getAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(salaryService.getAll(pageNo, pageSize, sortBy));
    }

}
