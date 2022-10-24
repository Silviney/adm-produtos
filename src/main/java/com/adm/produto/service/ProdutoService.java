package com.adm.produto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adm.produto.entity.Produto;
import com.adm.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	public ProdutoRepository produtoRepository;

	public List<Produto> listAll(String palavraChave) {
		if(palavraChave != null) {
			return produtoRepository.findAll(palavraChave);
		}
		return produtoRepository.findAll();
	}

	public void save(Produto produto) {
		produtoRepository.save(produto);
	}

	public Produto get(Long id) {
		return produtoRepository.findById(id).get();
	}

	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}
}
