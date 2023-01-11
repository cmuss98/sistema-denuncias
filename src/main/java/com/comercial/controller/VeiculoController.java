package com.comercial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.domain.model.Veiculo;
import com.comercial.domain.service.VeiculoService;
import com.comercial.domain.service.CorBarraService;
import com.comercial.domain.service.LicencaService;
import com.comercial.domain.service.RotaService;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController 
{
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private RotaService rotaService;
	
	@Autowired
	private LicencaService licencaService;
	
	
	@GetMapping("/novo")
	public ModelAndView novo(Veiculo veiculo)
	{
		ModelAndView mv=new ModelAndView("veiculos/cadastro");
		mv.addObject("rotas", rotaService.listar());
		mv.addObject("licencas", licencaService.listar());
		return mv;

	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(Veiculo veiculo, RedirectAttributes attributes)
	{
		veiculoService.salvar(veiculo);
		attributes.addFlashAttribute("mensagem", String.format("Veiculo de matricula %s cadastrado com sucesso", veiculo.getMatricula()));
		return new ModelAndView("redirect:/veiculos/novo");
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		return new ModelAndView("veiculos/pesquisa").addObject("veiculos", veiculoService.listar());
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Veiculo veiculo, RedirectAttributes attributes)
	{
		attributes.addFlashAttribute("veiculo", veiculo);
		return new ModelAndView("redirect:/veiculos/novo");
	}

	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo)
	{
		veiculoService.remover(codigo);
		return new ModelAndView("redirect:/veiculos");
	}
	@GetMapping("/pesquisarCa")
	public ModelAndView getCA(String nomePesquisa)
	{
		ModelAndView mv=new ModelAndView("veiculos/pesquisa");
		mv.addObject("veiculos", veiculoService.pesquisarNome(nomePesquisa));
		return mv;
	}

}





