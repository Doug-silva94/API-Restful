package org.serratec.backend.projeto01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculadora {

	@RequestMapping("/mult")
	public double mult(@RequestParam double n1, double n2) {
		return n1*n2;
	}
	
	@RequestMapping("/div")
	public double div(@RequestParam double n1, double n2) {
		return n1/n2;
	}
	
	@RequestMapping("/soma")
	public double soma(@RequestParam double n1, double n2) {
		return n1+n2;
	}
	
	@RequestMapping("/sub")
	public double sub(@RequestParam double n1, double n2) {
		return n1-n2;
	}
}
