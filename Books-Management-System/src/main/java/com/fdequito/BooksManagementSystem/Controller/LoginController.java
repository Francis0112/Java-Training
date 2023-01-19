package com.fdequito.BooksManagementSystem.Controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.fdequito.BooksManagementSystem.Entity.User;
import com.fdequito.BooksManagementSystem.Service.UserService;

@Controller
public class LoginController {

	private UserService userService;
	
	
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}

	// handlers and mappings 

	@GetMapping("/login_form")
	public String loginform(@ModelAttribute("user_obj") User user) {
		return "login_form";
	}
	
	@PostMapping("/login_form/{email}/{password}")
	public String LoginSubmit(@Param("email") String email, @Param("password") String password,@ModelAttribute("user_obj") User user) {
			User log_email = userService.findByEmail(email);
			User log_pass = userService.findByPassword(password);
			try {
				String a = log_email.getEmail();
				String b = log_pass.getPassword();
				return "redirect:/books";
			} catch (Exception e) {
				return "redirect:/login_form?ramen";
			}
	}
}
