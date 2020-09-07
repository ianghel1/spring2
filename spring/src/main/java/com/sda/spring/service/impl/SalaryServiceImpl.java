package com.sda.spring.service.impl;

import com.sda.spring.dto.SalaryCreateDto;
import com.sda.spring.dto.SalaryInfoDto;
import com.sda.spring.model.Salary;
import com.sda.spring.repository.SalaryRepository;
import com.sda.spring.service.SalaryService;
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
public class SalaryServiceImpl implements SalaryService {

    private SalaryRepository salaryRepository;
    private ModelMapper modelMapper;

    @Autowired
    public SalaryServiceImpl(SalaryRepository salaryRepository, ModelMapper modelMapper) {
        this.salaryRepository = salaryRepository;
        this.modelMapper = modelMapper;

    }


    @Override
    public SalaryInfoDto create(SalaryCreateDto salaryCreateDto) {
        Salary entity = modelMapper.map(salaryCreateDto, Salary.class);
        Salary resultAfterSave = salaryRepository.save(entity);

        SalaryInfoDto response = modelMapper.map(resultAfterSave, SalaryInfoDto.class);
        return response;
    }

    @Override
    public List<Salary> saveAll(List<Salary> salaryList) {


        return (List<Salary>) salaryRepository.saveAll(salaryList);
//        return ((List<Salary>) salaryRepository.findAll())
//                .stream()
//                .map(obj -> modelMapper.map(obj, Salary.class))
//                .collect(Collectors.toList());
    }

    @Override
    public Salary getById(Integer id) {
        Optional<Salary> salaryFound = salaryRepository.findById(id);
        return salaryFound.get();
    }

    @Override
    public List<Salary> getByValue(Double value) {
        List<Salary> results = salaryRepository.findByValue(value);
        return results;
    }

    @Override
    public List<Salary> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Salary> pageResult = salaryRepository.findAll(pageable);
        return pageResult.getContent();
    }


}
