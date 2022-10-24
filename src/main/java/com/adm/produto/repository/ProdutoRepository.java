package com.adm.produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adm.produto.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %?1%"+ "OR p.marca LIKE %?1%"
			+ " OR p.marca LIKE %?1%"
			+ " OR p.madeIn LIKE %?1%"
			+ " OR p.preco LIKE %?1%"
			+ "ORDER BY p.nome")
	public List<Produto> findAll(String palavraChave);
}
