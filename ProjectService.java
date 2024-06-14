package com.example.bugtracker.Service;

import com.example.bugtracker.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public String createProject(Project project) {
        
        String insertProjectSql = "INSERT INTO projects (project_name, project_owner) VALUES (?, ?)";
        jdbcTemplate.update(insertProjectSql, project.getProjectName(), project.getProjectOwner());

        
        String insertDeveloperSql = "INSERT INTO project_developers (project_name, developer) VALUES (?, ?)";
        for (String developer : project.getDevelopers()) {
            jdbcTemplate.update(insertDeveloperSql, project.getProjectName(), developer);
        }

        return "Project created successfully";
    }
}
