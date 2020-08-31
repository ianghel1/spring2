package com.sda.spring.service.impl;

import com.sda.spring.model.Project;
import com.sda.spring.repository.ProjectRepository;
import com.sda.spring.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @Override
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> saveAll(List<Project> projectList) {
        return (List<Project>) projectRepository.saveAll(projectList);
    }

    @Override
    public Project getById(Integer id) {
        Optional<Project> foundProject = projectRepository.findById(id);
        return foundProject.get();
    }

    @Override
    public List<Project> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Project> pageResult = projectRepository.findAll(pageable);
        return pageResult.getContent();
    }
}
