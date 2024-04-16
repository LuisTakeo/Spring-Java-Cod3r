package br.com.cod3r.exerciciossbmaven.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping
	public Iterable<Produto> getProdutos()
	{
//		Pageable page = PageRequest.of(0, 20);
		return produtoRepository.findAll();
	}
	
	@GetMapping(path = "/nome/{partNome}")
	public Iterable<Produto> getProdutosPorNome(
			@PathVariable String partNome)
	{
//		Pageable page = PageRequest.of(0, 20);
		return produtoRepository.findByNomeContainingIgnoreCase(partNome);
	}
	
	@GetMapping(path = "/page/{numPage}/{qtdProdutos}")
	public Iterable<Produto> getProdutosByPage(
			@PathVariable int numPage,
			@PathVariable int qtdProdutos)
	{
		qtdProdutos = validateQtdProduct(qtdProdutos);
		Pageable page = PageRequest.of(numPage, qtdProdutos);
		return produtoRepository.findAll(page);
	}
	
	@GetMapping(path="/{id}")
	public Optional<Produto> getProdutoById(@PathVariable int id) 
	{
		return produtoRepository.findById(id);
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Produto updateProduto(@Valid Produto produto)
	{
		produtoRepository.save(produto);
		return produto;
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteProduto(@PathVariable int id)
	{
		produtoRepository.deleteById(id);;
	}
	
//	@PostMapping
//	public Produto newProduto(@Valid Produto produto)
//	{
////		if (!isValidPreco(produto.getPreco()) || !isValidDesconto(produto.getDesconto()))
////			return null;
//		produtoRepository.save(produto);
//		return produto;
//	}
//	
//	@PutMapping
//	public Produto updateProduto(@Valid Produto produto)
//	{
//		produtoRepository.save(produto);
//		return produto;
//	}
//	
	private int		validateQtdProduct(int qtd)
	{
		if (qtd > 50)
			qtd = 50;
		if (qtd <= 0)
			qtd = 5;
		return qtd;
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
