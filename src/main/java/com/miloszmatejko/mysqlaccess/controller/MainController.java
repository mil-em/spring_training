package com.miloszmatejko.mysqlaccess.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	@GetMapping("/displayAll")
	public String displayAllUsers(Model model) {
		
		model.addAttribute("userList", userRepository.findAll());
		return "userList";
	}
	
	
	@GetMapping("/findUser")
	public String findUser(Model model) {
		model.addAttribute("user", new User());
		return "userSearch";
	}
	
	
	@PostMapping("/findByName")
	public String findUser(@RequestParam String name, Model model) {
		
		model.addAttribute("userList", userRepository.findByName(name));
		
		return "userList";
	}
	
	
}
