package com.sda.spring.service.impl;

import com.sda.spring.dto.CompanyCreateDto;
import com.sda.spring.dto.CompanyInfoDto;
import com.sda.spring.exception.CompanyNotFoundException;
import com.sda.spring.exception.EmployeeNotFoundException;
import com.sda.spring.mapper.CompanyMapper;
import com.sda.spring.model.Company;
import com.sda.spring.model.Employee;
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
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    // @Autowired - dupa ce facem contructorul nu mai este nevoie de autowired
    private final CompanyRepository companyRepository;

    //@Autowired
    private final ModelMapper modelMapper;


    /**
     * la apelarea constructorului CompanyRepository si modelMapper sunt instantiate, de aceea nu este necesara adnotarea autowired
     */
    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CompanyInfoDto create(CompanyCreateDto companyCreateDto, String createdBy) {
        Company entity = modelMapper.map(companyCreateDto, Company.class);
        entity.setCreatedBy(createdBy);

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
    public CompanyInfoDto findByPersonalNumericCode(Long personalNumericCode) {

        Optional<Company> foundedCompany = companyRepository.findCompanyByPersonalNumericCode(personalNumericCode);
        Company entity = foundedCompany.orElseThrow(() -> new CompanyNotFoundException("Something went wrong"));


        if (entity.getEmployee() != null) {

            //Filtram lista cu angajati si extragem doar angajatul cautat de noi
            List<Employee> employeeList = entity.getEmployee().stream()
                    .filter(employee -> employee.getPersonalNumericCode().equals(personalNumericCode))
                    .collect(Collectors.toList());

            //inlocuim lista angajatilor doar cu angajatul cautat / filtrat mai sus
            entity.setEmployee(employeeList);
        }


        return modelMapper.map(entity, CompanyInfoDto.class);

    }

    /**
     * Exemplu fara modelMapper
     */
    @Override
    public CompanyInfoDto findByEmployeeId(Integer employeeId) {
        Optional<Company> foundedCompany = companyRepository.findCompanyByEmployeeId(employeeId);
        Company entity = foundedCompany.orElseThrow(() -> new EmployeeNotFoundException("something went wrong"));

        //Filtram lista cu angajati si extragem doar angajatul cautat de noi
        List<Employee> employeeList = entity.getEmployee().stream()
                .filter(employee -> employee.getId() == employeeId)
                .collect(Collectors.toList());

        //inlocuim lista angajatilor doar cu angajatul cautat / filtrat mai sus
        entity.setEmployee(employeeList);

        CompanyInfoDto companyInfoDto = CompanyMapper.entityToInfoDto(entity);
        return companyInfoDto;
    }


    @Override
    public List<Company> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Company> pageResult = companyRepository.findAll(pageable);  // alegem findAll de tip pageable
        return pageResult.getContent(); //ne da rezultatul din pageresult, adica lista de employee
    }
}
