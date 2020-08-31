package com.sda.spring.repository;

import com.sda.spring.model.Salary;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SalaryRepository extends PagingAndSortingRepository<Salary, Integer> {
}
