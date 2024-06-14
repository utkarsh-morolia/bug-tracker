package com.example.bugtracker.Controller;

import com.example.bugtracker.Service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class BugController {

    @Autowired
    private BugService bugService;

    @PostMapping("/bugs/assign")
    public ResponseEntity<String> assignBug(@RequestBody Map<String, String> assignMap) {
        Long id = Long.valueOf(assignMap.get("id"));
        Long projectId = Long.valueOf(assignMap.get("projectId"));
        String creator = assignMap.get("creator");
        String owner = assignMap.get("owner");

        String result = bugService.assignBug(id, projectId, creator, owner);
        if ("Bug assigned successfully".equals(result)) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
