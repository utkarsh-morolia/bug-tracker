package com.example.bugtracker.Controller;

import com.example.bugtracker.model.Project;
import com.example.bugtracker.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/createProject")
    public ResponseEntity<String> createProject(@RequestBody Project project) {
        String result = projectService.createProject(project);
        if ("Project created successfully".equals(result)) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
