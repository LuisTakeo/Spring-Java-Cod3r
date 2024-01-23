package br.com.cod3r.exerciciossbmaven.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossbmaven.model.entities.Cliente;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {
	
	@GetMapping(path = "/qualquer")
	public Cliente obterCliente()
	{
		return (new Cliente (28, "Pedro", "123.123.123-24"));
	}
	
	// passando parametro pela url
	// @path variable irá pegar o valor do parametro passado na url
	@GetMapping("/{id}")
	public Cliente obterClientePorId1(
			@PathVariable int id
	)
	{
		return new Cliente(id, "Maria", "xxx.123.456-xx");
	}
	
	@GetMapping
	public Cliente obterClientePorId2(
			@RequestParam(name = "id", defaultValue = "1") 
			int id
			)
	{
		return new Cliente(id, "João", "xxx.321.666-xx");
	}
}
