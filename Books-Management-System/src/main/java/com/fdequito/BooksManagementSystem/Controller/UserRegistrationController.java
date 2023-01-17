package com.fdequito.BooksManagementSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fdequito.BooksManagementSystem.Service.UserService;
import com.fdequito.BooksManagementSystem.Service.Web.DTO.UserRegistrationDTO;

@Controller
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	// mappings handler
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user_obj", new UserRegistrationDTO());
		return "registration";
	}
	
	@PostMapping("/register")
	public String registerUserAccount(@ModelAttribute("user_obj") UserRegistrationDTO registrationDTO) {
		userService.save(registrationDTO);
		return "redirect:/register?ramen";
	}
}
