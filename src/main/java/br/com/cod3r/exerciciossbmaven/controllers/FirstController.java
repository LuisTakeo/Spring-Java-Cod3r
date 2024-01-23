package br.com.cod3r.exerciciossbmaven.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	
	@RequestMapping(method = RequestMethod.GET, path = {"/ola", "/salve"})
	public String ola()
	{
		return "Olá Spring Boot";
	}
	
	@GetMapping
	public String olaComGet()
	{
		return "<h1>Meu GET com Spring Boot</h1>";
	}
	
	@GetMapping(path = {"/testando", "/testes/*"})
	public String bomDia()
	{
		return "<h1>Bom dia! Testes com o Spring!</h1>";
	}
}
