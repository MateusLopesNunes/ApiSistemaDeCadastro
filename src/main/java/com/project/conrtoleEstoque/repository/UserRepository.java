package com.project.conrtoleEstoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.conrtoleEstoque.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
