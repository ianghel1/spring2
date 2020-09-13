package com.sda.spring.mapper;

import com.sda.spring.dto.CompanyInfoDto;
import com.sda.spring.model.Company;

import static com.sda.spring.mapper.EmployeeMapper.toEmployeeSummaryDtoList;

public class CompanyMapper {

    public static CompanyInfoDto entityToInfoDto(Company company) {
        CompanyInfoDto companyInfoDto = new CompanyInfoDto();
        companyInfoDto.setId(company.getId());
        companyInfoDto.setName(company.getName());
        companyInfoDto.setAddress(company.getAddress());
        companyInfoDto.setEmail(company.getEmail());
        companyInfoDto.setPhoneNumberCompany(company.getPhoneNumberCompany());
        companyInfoDto.setRegistrationNumber(company.getRegistrationNumber());
        companyInfoDto.setCreatedAt(company.getCreatedAt());
        companyInfoDto.setUpdatedAt(company.getUpdatedAt());
        companyInfoDto.setEmployeeList(toEmployeeSummaryDtoList(company.getEmployee()));

        return companyInfoDto;
    }





}
