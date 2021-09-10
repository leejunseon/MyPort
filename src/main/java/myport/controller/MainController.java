package myport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/*")
public class MainController {

	@GetMapping("/dashboard")
	public void dashboard() {
		
	}
	
	@GetMapping("/asset")
	public void asset() {
		
	}
	
	@GetMapping("/investment")
	public void investment() {
		
	}
}
