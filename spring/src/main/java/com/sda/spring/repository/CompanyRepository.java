package com.sda.spring.repository;

import com.sda.spring.model.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Integer> {
    List<Company> findByName(String name);
}
