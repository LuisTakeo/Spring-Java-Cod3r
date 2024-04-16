package br.com.cod3r.exerciciossbmaven.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.cod3r.exerciciossbmaven.model.entities.Produto;

// CrudRepository usado para consultas simples
// 
public interface ProdutoRepository 
	extends PagingAndSortingRepository<Produto, Integer>,
	CrudRepository<Produto, Integer>
{
	public Iterable<Produto> findByNomeContainingIgnoreCase(String partNome);
}
