package com.sda.spring.service.impl;

import com.sda.spring.dto.CompanyInfoDto;
import com.sda.spring.model.Company;
import com.sda.spring.dto.CompanyCreateDto;
import com.sda.spring.repository.CompanyRepository;
import com.sda.spring.service.CompanyService;
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
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final ModelMapper modelMapper;

    /**
     * When constructor is called, CompanyRepo and ModelMapper is instantiated, therefore there's no use of @Autowired
     */

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CompanyInfoDto create(CompanyCreateDto companyCreateDto) {
        Company entity = modelMapper.map(companyCreateDto, Company.class);
        Company resultAfterSave = companyRepository.save(entity);

        CompanyInfoDto response = modelMapper.map(resultAfterSave, CompanyInfoDto.class);
        return response;
    }

    @Override
    public List<Company> saveAll(List<Company> companyList) {

        return (List<Company>) companyRepository.saveAll(companyList);
    }

    @Override
    public Company getById(Integer id) {
        Optional<Company> foundCompany = companyRepository.findById(id);
        return foundCompany.get();
    }

    @Override
    public List<Company> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Company> pageResult = companyRepository.findAll(pageable);
        return pageResult.getContent();
    }


}
