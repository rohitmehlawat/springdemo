package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.domain.UserDto;
import com.example.repository.UserRepository;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository; 
     
    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) throws Exception {
         
        if (emailExist(accountDto.getEmail())) {  
            throw new Exception("There is an account with that email address:"  + accountDto.getEmail());
        }
       
        User user = new User();  
        user.setId("1");
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        System.out.println(user);
        System.out.println(repository.findAll().get(0).getFirstName());
        repository.save(user); 
        return user;
    }
    private boolean emailExist(String email) {
        User user = repository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
    @Transactional
    @Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
}
