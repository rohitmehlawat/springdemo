package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.User;
import com.example.domain.UserDto;
import com.example.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService service;
	
	@PostMapping("/user/registration")
	public ModelAndView registerUserAccount(
			@ModelAttribute("user") @Valid UserDto accountDto,
			BindingResult result, WebRequest webRequest,Errors errors
			) {
		User registered = new User();
		if (!result.hasErrors()) {
	        registered = createUserAccount(accountDto, result);
	    }
		if (registered == null) {
	        result.rejectValue("email", "message.regError");
	    }
		
	    if (result.hasErrors()) {
	        return new ModelAndView("registration", "user", accountDto);
	    } 
	    else {
	    	
	        return new ModelAndView("home", "user", accountDto);
	    }
		
		
	}
	
	@ResponseBody
	@RequestMapping("/getUsers")
	public  List<User> getALlUsers(){
		
		return service.getAllUsers();
	}
	
	private User createUserAccount(UserDto accountDto, BindingResult result) {
	    User registered = null;
	    try {
	    	
	        registered = service.registerNewUserAccount(accountDto);
	    } catch (Exception e) {
	        return null;
	    }    
	    return registered;
	}
}
