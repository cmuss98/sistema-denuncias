package com.comercial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.domain.model.Reclamacao;
import com.comercial.domain.model.Veiculo;
import com.comercial.domain.service.LicencaService;
import com.comercial.domain.service.ReclamacaoService;
import com.comercial.domain.service.RotaService;
import com.comercial.domain.service.VeiculoService;

@Controller
@RequestMapping("/reclamacoes")
public class ReclamacaoController 
{
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private ReclamacaoService reclamacaoService;
	
	
	@GetMapping("/novo")
	public ModelAndView novo()
	{
		return new ModelAndView("reclamacoes/cadastro").addObject("veiculos",veiculoService.listar());
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(Reclamacao reclamacao, RedirectAttributes attributes)
	{
		reclamacaoService.salvar(reclamacao);
		attributes.addFlashAttribute("mensagem", String.format("Reclamacao de veiculo %s cadastrado com sucesso", reclamacao.getVeiculo()));
		return new ModelAndView("redirect:/reclamacoes/novo");
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		return new ModelAndView("reclamacoes/pesquisa").addObject("reclamacoes", reclamacaoService.listar());
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Reclamacao reclamacao, RedirectAttributes attributes)
	{
		reclamacao.setStatus("Finalizada");
		attributes.addFlashAttribute("reclamacao", reclamacao);
		return new ModelAndView("redirect:/reclamacoes/novo");
	}

	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo)
	{
		reclamacaoService.remover(codigo);
		return new ModelAndView("redirect:/reclamacoes");
	}
	@GetMapping("/pesquisarCa")
	public ModelAndView getCA(String nomePesquisa)
	{
		ModelAndView mv=new ModelAndView("reclamacoes/pesquisa");
		mv.addObject("reclamacoes", reclamacaoService.pesquisarNome(nomePesquisa));
		return mv;
	}

}


