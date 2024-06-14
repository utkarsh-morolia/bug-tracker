package com.example.bugtracker.model;

import java.util.List;

public class Project {
    private String projectName;
    private String projectOwner;
    private List<String> developers;

    
    public Project() {}

    public Project(String projectName, String projectOwner, List<String> developers) {
        this.projectName = projectName;
        this.projectOwner = projectOwner;
        this.developers = developers;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(String projectOwner) {
        this.projectOwner = projectOwner;
    }

    public List<String> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<String> developers) {
        this.developers = developers;
    }
}
