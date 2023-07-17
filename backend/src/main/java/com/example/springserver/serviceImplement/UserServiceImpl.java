package com.example.springserver.serviceImplement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springserver.dto.UserDTO;
import com.example.springserver.exception.ResourceNotFound;
import com.example.springserver.mapper.UserMapper;
import com.example.springserver.modal.User;
import com.example.springserver.repo.UserRepo;
import com.example.springserver.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	private UserRepo userRepo;
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = UserMapper.mapToUser(userDTO);
		User userRes =  userRepo.save(user);
		return UserMapper.mapToUserDTO(userRes);
	}
	@Override
	public UserDTO getUserById(Long userId) {
		User user =  userRepo.findById(userId).orElseThrow(
				()-> new ResourceNotFound("User With Id :"+userId+" not Found")
				);
		return UserMapper.mapToUserDTO(user);
		
	}
	@Override
	public List<UserDTO> getAllUsers() {
		List<User>  users=  userRepo.findAll();
		return users.stream().map(
				(user)->UserMapper.mapToUserDTO(user)
				).collect(Collectors.toList());
	}
	@Override
	public UserDTO updateUser(Long userId, UserDTO userDTO) {
		User user =  userRepo.findById(userId).orElseThrow(
				()->new ResourceNotFound("User With Id :"+userId+" not Found")
				);
		user.setCity(userDTO.getCity());
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setPassword(user.getPassword());
		user.setStreet(userDTO.getStreet());
		user.setTel(userDTO.getTel());
		user.setZipcode(userDTO.getZipcode());
		
		User updatedUser =  userRepo.save(user);
		
		return UserMapper.mapToUserDTO(updatedUser);
	}
	@Override
	public void deleteUser(Long userId) {
		userRepo.findById(userId).orElseThrow(
				()->new ResourceNotFound("User With Id :"+userId+" not Found")
				);
		userRepo.deleteById(userId);
	}
	@Override
	public void deleteByEmail(String email) {
		System.out.println("TODO");
		
	}

}
