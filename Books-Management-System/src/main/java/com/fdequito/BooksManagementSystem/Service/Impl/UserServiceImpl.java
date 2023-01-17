package com.fdequito.BooksManagementSystem.Service.Impl;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.fdequito.BooksManagementSystem.Entity.Role;
import com.fdequito.BooksManagementSystem.Entity.User;
import com.fdequito.BooksManagementSystem.Repository.UserRepository;
import com.fdequito.BooksManagementSystem.Service.UserService;
import com.fdequito.BooksManagementSystem.Service.Web.DTO.UserRegistrationDTO;

@Service
public class UserServiceImpl implements UserService {

	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User save(UserRegistrationDTO userRegistrationDTO) {
		// TODO Auto-generated method stub
		User user = new User(
				userRegistrationDTO.getFirstname(),
				userRegistrationDTO.getLastname(),
				userRegistrationDTO.getEmail(),
				userRegistrationDTO.getPassword(),
				Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}

}
