package com.sda.spring.controller;


import com.sda.spring.components.CustomFaker;
import com.sda.spring.dto.SalaryCreateDto;
import com.sda.spring.dto.SalaryInfoDto;
import com.sda.spring.model.Salary;
import com.sda.spring.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<SalaryInfoDto> create(@Valid @RequestBody SalaryCreateDto salaryCreateDto) {
        return ResponseEntity.ok(salaryService.create(salaryCreateDto));
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

    @GetMapping("/populate")
    public void faker() {
        salaryService.saveAll(customFaker.createDummySalaryList());
    }

    @GetMapping("/findByValue")
    public ResponseEntity<List<Salary>> getByValue(
            @RequestParam Double value) {
        return ResponseEntity.ok(salaryService.getByValue(value));
    }


}
