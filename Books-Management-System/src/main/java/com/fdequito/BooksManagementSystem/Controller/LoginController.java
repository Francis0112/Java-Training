package com.fdequito.BooksManagementSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.fdequito.BooksManagementSystem.Service.UserService;
import com.fdequito.BooksManagementSystem.Service.Web.DTO.UserLoginDTO;

@Controller
public class LoginController {

	private UserService userService;

	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	// handlers and mappings 
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("user_obj", new UserLoginDTO());
		return "login";
	}
	
	@PostMapping("/login")
	public String LoginSubmit(@ModelAttribute UserLoginDTO userLoginDTO, Model model) {
		model.addAttribute("user_obj", userLoginDTO);
		if (userLoginDTO.getEmail().equals("francis@yahoo.com")&&userLoginDTO.getPassword().equals("a123") ) {
			return "login_result";
		}
		else {
			return "invalid_login";
		}
	}
}
