package com.sda.spring.service;

import com.sda.spring.model.Project;

import java.util.List;

public interface ProjectService {


    Project create(Project project);

    List<Project> saveAll(List<Project> projectList);

    Project getById(Integer id);

    List<Project> getAll(Integer pageNo, Integer pageSize, String sortBy);
}
