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
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api/v1/companies")
@ControllerAdvice
public class CompanyController {


    @Autowired
    private CompanyService companyService;

    @Autowired
    private CustomFaker customFaker;


    @PostMapping("/save")
    public ResponseEntity<CompanyInfoDto> create(@Valid @RequestBody CompanyCreateDto companyCreateDto, Principal principal) {
        String userName = principal != null ? principal.getName() : "unauthorized person";
        return ResponseEntity.ok(companyService.create(companyCreateDto, userName));
    }

    @GetMapping("/findByEmployee")
    public ResponseEntity<CompanyInfoDto> findByEmployee(@RequestParam @NotNull Long personalNumericCode) {

        return ResponseEntity.ok(companyService.findByPersonalNumericCode(personalNumericCode));
    }

    @GetMapping("/findByEmployeeId/{id}")
    public ResponseEntity<CompanyInfoDto> findByEmployeeId(@PathVariable @NotNull Integer id) {
        return ResponseEntity.ok(companyService.findByEmployeeId(id));
    }

    @GetMapping("/getById")
    public ResponseEntity<Company> getById(@RequestParam Integer id) {
        return ResponseEntity.ok(companyService.getById(id));
    }


    @GetMapping("/getAll")  //teava prin care intra si ies datele din aplicatie in baza de date
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
