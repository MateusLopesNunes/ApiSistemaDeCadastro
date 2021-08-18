package com.project.conrtoleEstoque.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.conrtoleEstoque.dto.UserDto;
import com.project.conrtoleEstoque.model.User;
import com.project.conrtoleEstoque.service.UserService;

@RestController
@RequestMapping("/api/v1/estoque")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public String createUser(@RequestBody @Valid UserDto obj) {
		return userService.createUser(obj);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<User> listAll() {
		return userService.listAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public User findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable Long id) {
		return userService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody @Valid UserDto obj) {
		return userService.updateUser(id, obj);
	}
	
}
