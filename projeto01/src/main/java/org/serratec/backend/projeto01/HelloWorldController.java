package org.serratec.backend.projeto01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloWorldController {
	
	
	@RequestMapping("/ola")
	public String OlaMundo() {
		return "Olá Mundo";
	}
	@RequestMapping("/maiuscula")
	public String toUpper(@RequestParam String valor) {
		return valor.toUpperCase();
	}
}
