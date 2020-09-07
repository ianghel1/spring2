package com.sda.spring.repository;

import com.sda.spring.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company,Integer>{

    @Query("SELECT company FROM Company company JOIN company.employee employees WHERE employees.personalNumericCode = :personalNumericCode ")
    Optional<Company> findCompanyByPersonalNumericCode(@Param("personalNumericCode") Long personalNumericCode);

    @Query("SELECT company From Company company JOIN company.employee employees WHERE employees.id = :employeeId")
    Optional<Company> findCompanyByEmployeeId(@Param("employeeId") Integer employeeId);
}
