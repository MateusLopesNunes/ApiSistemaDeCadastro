package com.project.conrtoleEstoque.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import com.project.conrtoleEstoque.model.User;

public class UserDto {
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Long id;
	
	@NotEmpty
	@Size(min = 5, max = 100)
	private String name;
	
	@NotEmpty
	@Size(min = 5, max = 80)
	private String login;

	@NotEmpty
	@Size(min = 8, max = 50)
	private String senha;

	@NotEmpty
	@Size(min = 10, max = 150)
	@Email
	private String email;

	@NotEmpty
	@CPF
	private String cpf;
	
	public UserDto() {
	}

	public UserDto(Long id, String name, String login, String senha, String email, String cpf) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public User dtoToModel() {
		return new User(name, login, senha, email, cpf);
	}

	public UserDto(@NotEmpty @Size(min = 5, max = 80) String login, @NotEmpty @Size(min = 8, max = 50) String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
}
