package com.example.bugtracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public String registerUser(String username, String password, String email) {
		if(userExits(username,email)) {
			return "Username or email already exist";
		}
		
		
		 String encryptedPassword = passwordEncoder.encode(password);
		 String insertSql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
	        jdbcTemplate.update(insertSql,username , encryptedPassword, password, email);

	        return "User registered successfully";
		
	}
	
	
	
	
	public boolean userExits(String username, String email) {
		String querysql = "SELECT * FROM users WHERE username = ? email = ?";
		int count = jdbcTemplate.queryForObject(querysql, Integer.class,username,email);
		return count > 0;
	}
}
