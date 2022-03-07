package cybersoft.javabackend.java16giranhan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	@GetMapping
	public Object welcome() {
		
		
		return "welcome to gira project";
	}
}
