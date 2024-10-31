package pe.edu.uni.app.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
public class DemoRest {
	
	@GetMapping
	public String saludo() {
		return "Hola todos";
	}

}
