package com.sda.spring.repository;

import com.sda.spring.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Integer> {
    List<Project> findByProjectName(String name);
}
