package com.sda.spring.controller;


import com.sda.spring.components.CustomFaker;
import com.sda.spring.dto.ProjectCreateDto;
import com.sda.spring.dto.ProjectInfoDto;
import com.sda.spring.model.Employee;
import com.sda.spring.model.Project;
import com.sda.spring.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/project")
@ControllerAdvice
public class ProjectController {

    private ProjectService projectService;
    private CustomFaker customFaker;

    @Autowired
    public ProjectController(ProjectService projectService, CustomFaker customFaker){
        this.customFaker = customFaker;
        this.projectService = projectService;
    }

    @PostMapping("/save")
    public ResponseEntity<ProjectInfoDto> create(@Valid @RequestBody ProjectCreateDto projectCreateDto){
        return ResponseEntity.ok(projectService.create(projectCreateDto));
    }

    @GetMapping("/getById")
    public ResponseEntity<Project> getById(@RequestParam Integer id){
        return ResponseEntity.ok(projectService.getById(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Project>> getAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(projectService.getAll(pageNo, pageSize, sortBy));
    }

    @GetMapping("/populate")
    public void faker() {
        projectService.saveAll(customFaker.createDummyProjectList());
    }


    @GetMapping("/findByName")
    public ResponseEntity<List<Project>> getByName(
            @RequestParam String name) {

        return ResponseEntity.ok(projectService.getByName(name));
    }


}
