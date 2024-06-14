package com.example.bugtracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class BugService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    

    public String assignBug(Long id, Long projectId, String creator, String owner) {
        if (!isDeveloperPartOfProject(projectId, owner)) {
            return "Developer is not part of the project";
        }

        String updateBugSql = "UPDATE bugs SET owner = ?, creator = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(updateBugSql, owner, creator, id);

        if (rowsAffected > 0) {
            return "Bug assigned successfully";
        } else {
            return "Bug assignment failed";
        }
    }

    private boolean isDeveloperPartOfProject(Long projectId, String developerName) {
        String checkDeveloperSql = "SELECT COUNT(*) FROM project_developers WHERE project_id = ? AND developer = ?";
        Integer count = jdbcTemplate.queryForObject(checkDeveloperSql, Integer.class, projectId, developerName);
        return count != null && count > 0;
    }
}
