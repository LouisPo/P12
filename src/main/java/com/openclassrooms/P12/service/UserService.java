package com.openclassrooms.P12.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.openclassrooms.P12.entities.DicoUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.openclassrooms.P12.dto.UserDtoDS;
import com.openclassrooms.P12.dto.UserRegistrationDto;

import com.openclassrooms.P12.entities.Role;

import com.openclassrooms.P12.repository.UserRepository;

@Service
public class UserService implements UserDtoDS {
	private final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired
	RoleService roleService;

	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public DicoUser save(UserRegistrationDto userRegistrationDto) {
		Role roleUserParDefaut = roleService.getOneRoleById(2);
		logger.info("In DicoUserDtoDsImplem in save");
		DicoUser dicoUser = new DicoUser(userRegistrationDto.getFirstName(),
				userRegistrationDto.getLastName(), userRegistrationDto.getEmail(),
				userRegistrationDto.getAddress(), userRegistrationDto.getPhone(),
				passwordEncoder.encode(userRegistrationDto.getPassword()), Arrays.asList(roleUserParDefaut)
				);
		return saveDicoUser(dicoUser);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		logger.info("In DicoUserDtoDsImplem in loadUserByUsername");
		DicoUser dicoUser = userRepository.findByEmail(username);
		if (dicoUser == null) {
			throw new UsernameNotFoundException("Invalid email or Password");
		}
		return new org.springframework.security.core.userdetails.User(dicoUser.getEmail(), dicoUser.getPassword(),
				mapRolesToAuthorities(dicoUser.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {

		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

// methodes standard générales 

	public DicoUser getOneDicoUserById(Integer id) {
		logger.info("in DicoUserService in getOneDicoUserById method");
		return userRepository.getById(id);
	}

	public DicoUser getOneDicoUserByEmail(String email) {
		logger.info("in DicoUserService in getOneDicoUserByEmail method");
		return userRepository.findByEmail(email);
	}


	public DicoUser saveDicoUser(DicoUser dicoUser) {
		logger.info("in DicoUserService in saveDicoUser method");
		return userRepository.save(dicoUser);
	}

	public DicoUser findDicoUserByEmail(String email) {
		logger.info("in DicoUserService in findDicoUserByEmail method");
		return userRepository.findByEmail(email);
	}
	
	public List<DicoUser> getAllDicoUsers(){
		logger.info("in DicoUserService in gettAllDicoUsers method");
		return userRepository.findAll();
	}

// methodes utiles specifiquement pour une personne connectée, 
//	pour ses modifications d'éléments de compte

	public DicoUser emailModification(DicoUser dicoUser, String email) {
		logger.info("in DicoUserService in emailModification method");
		dicoUser.setEmail(email);
		return saveDicoUser(dicoUser);
	}

	public boolean emailAlreadyExists(UserRegistrationDto DicoUserDto) {
		logger.info("in DicoUserService in emailAlreadyExists method");
		String email = DicoUserDto.getEmail();
		if (userRepository.findByEmail(email) != null) {
			return true;
		}
		return false;
	}



	public void DicoUserInfosModification(DicoUser currentDicoUser, String firstName, String lastName,
											 String address, String phone) {
		logger.info("in DicoUserService in DicoUserInfosModification method");
		currentDicoUser.setFirstName(firstName);
		currentDicoUser.setLastName(lastName);
		currentDicoUser.setAddress(address);
		currentDicoUser.setPhone(phone);
		userRepository.save(currentDicoUser);

	}
	
	
	public void DicoUserPasswordModification(DicoUser currentDicoUser, String password) {
		logger.info("in DicoUserService in DicoUserPasswordModification method");
		currentDicoUser.setPassword(passwordEncoder.encode(password));
		userRepository.save(currentDicoUser);
	}

	public void DicoUserEmailModification(DicoUser currentDicoUser, String email) {
		logger.info("in DicoUserService in DicoUserEmailModification method");
		currentDicoUser.setEmail(email);
		userRepository.save(currentDicoUser);
	}

	

	

}
