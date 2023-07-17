package com.example.springserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private long id;
	private String name;
	private String email;
	private String street;
	private String city;
	private int zipcode;
	private String tel;
	private String password;
}
