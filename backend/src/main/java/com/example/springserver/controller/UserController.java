package com.example.springserver.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springserver.dto.UserDTO;
import com.example.springserver.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
	private UserService userService;
	
	//add employee RestAPI
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
		UserDTO saveDto = userService.createUser(userDTO);
		return new ResponseEntity<>(saveDto,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("id") long userId){
		UserDTO userDTO =  userService.getUserById(userId);
		return ResponseEntity.ok(userDTO);
	}
	
	@GetMapping()
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List<UserDTO> users =  userService.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long userId, @RequestBody UserDTO userDTO){
		UserDTO updatedUser =  userService.updateUser(userId, userDTO);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long userId){
		userService.deleteUser(userId);
		return ResponseEntity.ok("Employee Deleted Succesfully");
	}

}
