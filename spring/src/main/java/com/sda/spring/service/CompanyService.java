package com.sda.spring.service;

import com.sda.spring.dto.CompanyInfoDto;
import com.sda.spring.model.Company;
import com.sda.spring.dto.CompanyCreateDto;

import java.util.List;

public interface CompanyService {

    CompanyInfoDto create(CompanyCreateDto companyCreateDto);

    List<Company> saveAll(List<Company> companyList);

    Company getById(Integer id);

    List<Company> getAll(Integer pageNo, Integer pageSize, String sortBy);

}
