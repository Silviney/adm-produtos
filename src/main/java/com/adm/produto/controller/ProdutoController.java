package com.adm.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adm.produto.entity.Produto;
import com.adm.produto.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		List<Produto> listaProduto = produtoService.listAll();
		modelo.addAttribute("listaProduto", listaProduto);
		return "index";
	}
	
	
}
