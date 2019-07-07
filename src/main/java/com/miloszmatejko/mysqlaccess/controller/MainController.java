package com.miloszmatejko.mysqlaccess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miloszmatejko.mysqlaccess.entity.User;
import com.miloszmatejko.mysqlaccess.repos.UserRepository;

@Controller
public class MainController {

	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/add")
	public String addNewUserForm (Model model) {
		model.addAttribute("user", new User());
		return "user";
	}
	
	
	@PostMapping("/add")
	public String create(@ModelAttribute User user) {
		
		userRepository.save(user);
		return "confirmation";
	}
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}
	
}
