package com.sda.spring.controller;


import com.sda.spring.components.CustomFaker;
import com.sda.spring.model.Project;
import com.sda.spring.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Project> create(@RequestBody Project project){
        return ResponseEntity.ok(projectService.create(project));
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





}
