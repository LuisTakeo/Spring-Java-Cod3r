package br.com.cod3r.exerciciossbmaven.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossbmaven.model.entities.Produto;
import br.com.cod3r.exerciciossbmaven.model.repositories.ProdutoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
//	@PostMapping
//	public Produto newProduto(
//			@RequestParam
//			String nome,
//			@RequestParam
//			double preco,
//			@RequestParam
//			double desconto
//			)
	@PostMapping
	public Produto newProduto(@Valid Produto produto)
	{
//		if (!isValidPreco(produto.getPreco()) || !isValidDesconto(produto.getDesconto()))
//			return null;
		produtoRepository.save(produto);
		return produto;
	}
	
//	private boolean isValidPreco(double preco)
//	{
//		return (preco > 0);
//	}
//	
//	private boolean isValidDesconto(double desconto)
//	{
//		return (desconto >= 0 && desconto <= 1);
//	}
}
