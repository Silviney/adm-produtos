package com.adm.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.adm.produto.entity.Produto;
import com.adm.produto.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		 String palavraChave = "Accer";
		List<Produto> listaProduto = produtoService.listAll(palavraChave);
		modelo.addAttribute("listaProduto", listaProduto);
		return "index";
	}
	
	@RequestMapping("/novo")
	public String mostrarFomularioDeCadastro (Model modelo) {
		Produto produto = new Produto();
		modelo.addAttribute("produto", produto);
		return "novo_produto";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvarProduto(@ModelAttribute("produto") Produto produto) {
		produtoService.save(produto);
		return "redirect:/";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView mostrarFomularioDeAtualizacao (@PathVariable(name = "id") Long id) {
		ModelAndView modelo = new ModelAndView("editar_produto");
		
		Produto produto = produtoService.get(id);
		modelo.addObject("produto", produto);
		
		return modelo;
	}
	
	@RequestMapping("/deletar/{id}")
	public String deletarProduto (@PathVariable(name = "id") Long id) {
		produtoService.delete(id);
		return "redirect:/";
	}
	
	
}
