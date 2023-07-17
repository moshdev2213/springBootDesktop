package com.example.springserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springserver.modal.User;

public interface UserRepo extends JpaRepository<User, Long> {
	

}
