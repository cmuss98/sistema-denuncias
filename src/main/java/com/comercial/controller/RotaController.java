package com.comercial.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.domain.model.Rota;
import com.comercial.domain.repository.RotaRepository;
import com.comercial.domain.service.RotaService;
import com.comercial.domain.service.CorBarraService;

import groovyjarjarpicocli.CommandLine.Model;


@Controller
@RequestMapping("/rotas")
public class RotaController {
	@Autowired
	private RotaService rotaService;
	
	@Autowired
	private CorBarraService coresBarraService;
	
	@GetMapping("/novo")
	public ModelAndView novo(Rota rota)
	{
		
		return new ModelAndView("rotas/cadastro").addObject("coresBarra",coresBarraService.listar());
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(Rota rota, RedirectAttributes attributes)
	{
		rotaService.salvar(rota);
		attributes.addFlashAttribute("mensagem", String.format("Rota de via %s cadastrado com sucesso", rota.getVia()));
		return new ModelAndView("redirect:/rotas/novo");
	}
	@GetMapping("/pesquisarCa")
	public ModelAndView getCA(String nomePesquisa)
	{
		ModelAndView mv=new ModelAndView("rotas/pesquisa");
		mv.addObject("rotas", rotaService.pesquisarNome(nomePesquisa));
		return mv;
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		return new ModelAndView("rotas/pesquisa").addObject("rotas", rotaService.listar());
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Rota rota, RedirectAttributes attributes)
	{
		attributes.addFlashAttribute("rota", rota);
		return new ModelAndView("redirect:/rotas/novo");
	}

	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo)
	{
		rotaService.remove(codigo);
		return new ModelAndView("redirect:/rotas");
	}
	
	

}


