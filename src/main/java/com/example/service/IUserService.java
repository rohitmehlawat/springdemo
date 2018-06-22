package com.example.service;

import java.util.List;

import com.example.domain.User;
import com.example.domain.UserDto;

public interface IUserService {

	
	User registerNewUserAccount(UserDto accountDto)
		throws Exception;
	
	List<User> getAllUsers();
}
