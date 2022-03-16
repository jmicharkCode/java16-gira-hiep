package cybersoft.javabackend.java16girahiep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	@GetMapping("welcome")
	public Object Welcome() {
		return "Welcome to Gira Application";
	}
}
