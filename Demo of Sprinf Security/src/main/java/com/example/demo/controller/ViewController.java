package com.example.demo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.User;

@Controller
public class ViewController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
	    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("currentuser", userDetails.getUsername());
	    model.addAttribute("currentpassword", userDetails.isAccountNonLocked());
	    return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}


	@GetMapping("/trail")
	public String test(Model model) {
		String text="This is the example of data carrying";
		    model.addAttribute("text", text);
		return "test";
	}
}
