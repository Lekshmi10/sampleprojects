package com.Test.SampleProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ViewController {

	@GetMapping("/getTestPage")
	public String getPage() {
		return "test.html";
	}
	@GetMapping("/getTestPage1")
	public String getPage1() {
		return "test.html";
	}

}
