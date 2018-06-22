package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.UserDto;
@Controller
@SpringBootApplication
public class SpringRegistrationDemoApplication {

	@RequestMapping("/")
	public ModelAndView startPage() {
		ModelAndView viewName=new ModelAndView();
		UserDto userDto=new UserDto();
		viewName.addObject("user",userDto);
		viewName.setViewName("registration");
		return viewName;
	}
	public static void main(String[] args) {
		
		SpringApplication.run(SpringRegistrationDemoApplication.class, args);
	}
}
