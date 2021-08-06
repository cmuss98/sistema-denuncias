package com.comercial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.domain.model.Cliente;
import com.comercial.domain.service.ClienteService;
import com.comercial.domain.service.NacionalidadeService;
import com.comercial.domain.service.VooService;

@Controller
@RequestMapping("/clientes")
public class ClienteController 
{
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private VooService vooService;
	
	@Autowired
	private NacionalidadeService nacionalidadeService;
	
	@GetMapping("/novo")
	public ModelAndView novo(Cliente cliente)
	{
		ModelAndView mv=new ModelAndView("clientes/cadastro");
		mv.addObject("voos",vooService.listar());
		mv.addObject("nacionalidades",nacionalidadeService.listar());
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(Cliente cliente, RedirectAttributes attributes)
	{
		clienteService.salvar(cliente);
		attributes.addFlashAttribute("mensagem", String.format("Cliente de nome %s cadastrado com sucesso", cliente.getNome()));
		return new ModelAndView("redirect:/bilhetes/novo");
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		ModelAndView mv=new ModelAndView("clientes/pesquisa");
		mv.addObject("clientes", clienteService.listar());
		return mv;
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Cliente cliente, RedirectAttributes attributes)
	{
		attributes.addFlashAttribute("cliente", cliente);
		return new ModelAndView("redirect:/clientes/novo");
	}

	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo)
	{
		clienteService.remover(codigo);
		return new ModelAndView("redirect:/clientes");
	}
	@GetMapping("/pesquisarCa")
	public ModelAndView getCA(String nomePesquisa)
	{
		ModelAndView mv=new ModelAndView("clientes/pesquisa");
		mv.addObject("clientes", clienteService.pesquisarNome(nomePesquisa));
		return mv;
	}

}





