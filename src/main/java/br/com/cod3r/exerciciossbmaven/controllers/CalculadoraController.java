package br.com.cod3r.exerciciossbmaven.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcular")
public class CalculadoraController {
	@GetMapping("/somar/{a}/{b}")
	public int somar(
			@PathVariable
			int a, 
			@PathVariable
			int b)
	{
		return (a + b);
	}
	
	@GetMapping("/subtrair")
	public int subtrair(
			@RequestParam(name = "a", defaultValue = "0")
			int a, 
			@RequestParam(name = "b", defaultValue = "0")
			int b)
	{
		return (a - b);
	}
}
