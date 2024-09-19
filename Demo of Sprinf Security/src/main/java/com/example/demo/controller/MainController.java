package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BodyModel;

@RestController
@RequestMapping(("/api"))
public class MainController {

	@GetMapping("/test")
	public String test() {

		return "hi";
	}
	@PostMapping("/test1")
	public String test1(@RequestBody BodyModel bodyModel) {
return "hiiii";
	}

}
