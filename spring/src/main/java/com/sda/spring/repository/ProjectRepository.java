package com.sda.spring.repository;

import com.sda.spring.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Integer> {
}
