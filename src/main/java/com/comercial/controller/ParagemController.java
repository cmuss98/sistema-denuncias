package com.comercial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.domain.model.Paragem;
import com.comercial.domain.model.Veiculo;
import com.comercial.domain.service.LicencaService;
import com.comercial.domain.service.ParagemService;
import com.comercial.domain.service.RotaService;

@Controller
@RequestMapping("/paragens")
public class ParagemController 
{
	
	
	@Autowired
	private RotaService rotaService;
	
	@Autowired
	private ParagemService paragemService;
	
	
	@GetMapping("/novo")
	public ModelAndView novo()
	{
		return new ModelAndView("paragens/cadastro").addObject("rotas", rotaService.listar());
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(Paragem paragem, RedirectAttributes attributes)
	{
		paragemService.salvar(paragem);
		attributes.addFlashAttribute("mensagem", String.format("Paragem de descricao %s cadastrado com sucesso", paragem.getDescricao()));
		return new ModelAndView("redirect:/paragens/novo");
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		return new ModelAndView("paragens/pesquisa").addObject("paragens", paragemService.listar());
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Paragem paragem, RedirectAttributes attributes)
	{
		attributes.addFlashAttribute("paragem", paragem);
		return new ModelAndView("redirect:/paragens/novo");
	}

	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo)
	{
		paragemService.remover(codigo);
		return new ModelAndView("redirect:/paragens");
	}
	@GetMapping("/pesquisarCa")
	public ModelAndView getCA(String nomePesquisa)
	{
		ModelAndView mv=new ModelAndView("paragens/pesquisa");
		mv.addObject("paragens", paragemService.pesquisarNome(nomePesquisa));
		return mv;
	}

}


