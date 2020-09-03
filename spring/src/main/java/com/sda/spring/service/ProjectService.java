package com.sda.spring.service;

import com.sda.spring.dto.ProjectCreateDto;
import com.sda.spring.dto.ProjectInfoDto;
import com.sda.spring.model.Project;

import java.util.List;

public interface ProjectService {


    ProjectInfoDto create(ProjectCreateDto projectCreateDto);

    List<Project> saveAll(List<Project> projectList);

    Project getById(Integer id);

    List<Project> getAll(Integer pageNo, Integer pageSize, String sortBy);

    List<Project> getByName(String name);
}
