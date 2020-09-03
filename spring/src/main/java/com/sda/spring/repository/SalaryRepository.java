package com.sda.spring.repository;

import com.sda.spring.model.Salary;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SalaryRepository extends PagingAndSortingRepository<Salary, Integer> {

        List<Salary> findByValue(Double value);

}
