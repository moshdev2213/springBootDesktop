package com.example.springserver.service;

import java.util.List;

import com.example.springserver.dto.UserDTO;

public interface UserService {
	UserDTO createUser(UserDTO userDTO);
	UserDTO getUserById(Long userId);
	List<UserDTO> getAllUsers();
	UserDTO updateUser(Long userId,UserDTO userDTO);
	void deleteUser(Long userId);
	void deleteByEmail(String email);
}
