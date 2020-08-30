package com.sda.spring.repository;

import com.sda.spring.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {


    List<Employee> findAllByFirstNameAndLastName(String firstName, String lastName);
}
