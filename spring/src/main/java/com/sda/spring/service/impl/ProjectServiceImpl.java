package com.sda.spring.service.impl;

import com.sda.spring.dto.ProjectCreateDto;
import com.sda.spring.dto.ProjectInfoDto;
import com.sda.spring.model.Project;
import com.sda.spring.repository.ProjectRepository;
import com.sda.spring.service.ProjectService;
import org.modelmapper.ModelMapper;
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
    private ModelMapper modelMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectInfoDto create(ProjectCreateDto projectCreateDto) {
        Project entity = modelMapper.map(projectCreateDto, Project.class);
        Project resultAfterSave = projectRepository.save(entity);

        ProjectInfoDto response = modelMapper.map(resultAfterSave, ProjectInfoDto.class);
        return response;
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

    @Override
    public List<Project> getByName(String name) {
        List<Project> results = projectRepository.findByProjectName(name);
        return results;
    }
}
