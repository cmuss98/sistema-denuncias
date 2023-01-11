package com.comercial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.domain.model.Funcionario;
import com.comercial.domain.service.FuncionarioService;
import com.comercial.domain.service.MoradaService;
import com.comercial.domain.service.TrabalhoService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController 
{
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private MoradaService moradaService;
	
	@Autowired
	private TrabalhoService trabalhoService;
	
	
	@GetMapping("/novo")
	public ModelAndView novo(Funcionario usuario)
	{
		ModelAndView mv=new ModelAndView("funcionarios/cadastro");
		mv.addObject("moradas", moradaService.listar());
		mv.addObject("trabalhos", trabalhoService.listar());
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(Funcionario funcionario, RedirectAttributes attributes)
	{
		funcionarioService.salvar(funcionario);
		attributes.addFlashAttribute("mensagem", String.format("Funcionario de nome %s cadastrado com sucesso", funcionario.getNome()));
		return new ModelAndView("redirect:/funcionarios/novo");
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		return new ModelAndView("funcionarios/pesquisa").addObject("funcionarios", funcionarioService.listar());
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Funcionario usuario, RedirectAttributes attributes)
	{
		attributes.addFlashAttribute("usuario", usuario);
		return new ModelAndView("redirect:/funcionarios/novo");
	}

	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo)
	{
		funcionarioService.remover(codigo);
		return new ModelAndView("redirect:/funcionarios");
	}
	@GetMapping("/pesquisarCa")
	public ModelAndView getCA(String nomePesquisa)
	{
		ModelAndView mv=new ModelAndView("funcionarios/pesquisa");
		mv.addObject("usuarios", funcionarioService.pesquisarNome(nomePesquisa));
		return mv;
	}

}


