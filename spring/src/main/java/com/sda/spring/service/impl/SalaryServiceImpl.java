package com.sda.spring.service.impl;

import com.sda.spring.model.Project;
import com.sda.spring.model.Salary;
import com.sda.spring.repository.SalaryRepository;
import com.sda.spring.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryServiceImpl implements SalaryService {

    private SalaryRepository salaryRepository;

    @Autowired
    public SalaryServiceImpl(SalaryRepository salaryRepository){
        this.salaryRepository = salaryRepository;
    }

    @Override
    public Salary create(Salary salary) {
        return salaryRepository.save(salary);
    }

    @Override
    public List<Salary> saveAll(List<Salary> salaryList) {
        return (List<Salary>) salaryRepository.saveAll(salaryList);
    }

    @Override
    public Salary getById(Integer id) {
        Optional<Salary> salaryFound = salaryRepository.findById(id);
        return salaryFound.get();
    }

    @Override
    public List<Salary> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Salary> pageResult = salaryRepository.findAll(pageable);
        return pageResult.getContent();
    }
}
