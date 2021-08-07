package com.project.conrtoleEstoque.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.conrtoleEstoque.dto.UserDto;
import com.project.conrtoleEstoque.model.User;
import com.project.conrtoleEstoque.repository.UserRepository;
import com.project.conrtoleEstoque.service.exception.UserNotFoundException;

@Service
public class UserService {

	private UserRepository userRepository;

	// private UserMapper userMapper = UserMapper.INSTANCE;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public String createUser(UserDto obj) {
		User user = userRepository.save(obj.dtoToModel());
		return "Registered User whith id: " + user.getId();
	}

	public List<User> listAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	public String deleteById(Long id) {
		findById(id);
		userRepository.deleteById(id);
		return "Deleted user whith id: " + id;
	}

	public ResponseEntity<User> updateUser(Long id, UserDto obj) {
		return userRepository.findById(id).map(x -> {
			x.setName(obj.getName());
			x.setLogin(obj.getLogin());
			x.setSenha(obj.getSenha());
			x.setEmail(obj.getEmail());
			x.setCpf(obj.getCpf());
			x.setBirthDate(LocalDate.parse(obj.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			User update = userRepository.save(x);
			return ResponseEntity.ok().body(update);
		}).orElse(ResponseEntity.notFound().build());
	}
}
