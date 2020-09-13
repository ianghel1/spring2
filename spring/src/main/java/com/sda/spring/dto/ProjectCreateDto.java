package com.sda.spring.dto;

import javax.validation.constraints.NotBlank;

public class ProjectCreateDto {

@NotBlank
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
