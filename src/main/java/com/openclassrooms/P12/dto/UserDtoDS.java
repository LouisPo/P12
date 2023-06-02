package com.openclassrooms.P12.dto;

import com.openclassrooms.P12.entities.DicoUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDtoDS extends UserDetailsService {
DicoUser save (UserRegistrationDto registrationDto);
}
