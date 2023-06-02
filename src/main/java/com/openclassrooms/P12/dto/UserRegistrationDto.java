package com.openclassrooms.P12.dto;

import java.util.Collection;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import com.openclassrooms.P12.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UserRegistrationDto {
	
	
	@Size(max=65, message="65 charactères maximum")
	@NotBlank(message="Ce champ ne doit pas être vide")
	private String firstName;
	
	
	@Size(max=65, message="65 charactères maximum")
	@NotBlank(message="Ce champ ne doit pas être vide")
	private String lastName;
	
	
	@Size(max=65, message="65 charactères maximum")
	@NotBlank(message="Ce champ ne doit pas être vide")
	private String email;

	
	@Size(max=65, message="65 charactères maximum")
	@NotBlank(message="Ce champ ne doit pas être vide")
	private String address;
	
	
	@Size(max=65, message="65 charactères maximum")
	@NotBlank(message="Ce champ ne doit pas être vide")
	private String phone;
	
	
	@Size(max=65, message="65 charactères maximum")
	@NotBlank(message="Ce champ ne doit pas être vide")
	private String password;
	
	private Collection<Role> roles;



}
