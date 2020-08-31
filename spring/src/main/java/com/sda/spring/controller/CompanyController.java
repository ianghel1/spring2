package com.sda.spring.controller;


import com.sda.spring.components.CustomFaker;
import com.sda.spring.dto.CompanyCreateDto;
import com.sda.spring.dto.CompanyInfoDto;
import com.sda.spring.model.Company;
import com.sda.spring.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    private CompanyService companyService;
    private CustomFaker customFaker;

    @Autowired
    public CompanyController(CompanyService companyService, CustomFaker customFaker){
        this.companyService = companyService;
        this.customFaker = customFaker;
    }

    @PostMapping("/save")
    public ResponseEntity<CompanyInfoDto> create(@Valid @RequestBody CompanyCreateDto companyCreateDto) {


        return ResponseEntity.ok(companyService.create(companyCreateDto));
    }

    @GetMapping("/getById")
    public ResponseEntity<Company> getById(@RequestParam Integer id) {

        return ResponseEntity.ok(companyService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Company>> getAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(companyService.getAll(pageNo, pageSize, sortBy));
    }


    @GetMapping("/populate")
    public void faker() {
        companyService.saveAll(customFaker.createDummyCompanyList());
    }


}
