package com.example.springserver.mapper;

import com.example.springserver.dto.UserDTO;
import com.example.springserver.modal.User;

public class UserMapper {
	public static UserDTO mapToUserDTO(User user) {
		return new UserDTO(
				user.getId(),
				user.getName(),
				user.getEmail(),
				user.getStreet(),
				user.getCity(),
				user.getZipcode(),
				user.getTel(),
				user.getPassword()
				);
	}
	public static User mapToUser(UserDTO userDTO) {
		return new User(
				userDTO.getId(),
				userDTO.getName(),
				userDTO.getEmail(),
				userDTO.getStreet(),
				userDTO.getCity(),
				userDTO.getZipcode(),
				userDTO.getTel(),
				userDTO.getPassword()
				);
	}
}
