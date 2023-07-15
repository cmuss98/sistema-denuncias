package com.comercial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.domain.model.Ocorrencia;
import com.comercial.domain.service.OcorrenciaService;
import com.comercial.domain.service.RotaService;



@Controller
@RequestMapping("/denuncias")
public class DenunciaController 
{
	@Autowired
	private OcorrenciaService denunciaService;
	@Autowired
	private RotaService rotaService;
	
	@GetMapping("/novo")
	public ModelAndView novo(Ocorrencia denuncia)
	{
		ModelAndView mv=new ModelAndView("denuncias/cadastro");
		mv.addObject("rotas", rotaService.listar());
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(Ocorrencia denuncia, RedirectAttributes attributes)
	{
		denunciaService.salvar(denuncia);
		attributes.addFlashAttribute("mensagem", String.format("Denuncia de matricula %s cadastrado com sucesso", denuncia.getMatricula()));
		return new ModelAndView("redirect:/denuncias/novo");
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		return new ModelAndView("denuncias/pesquisa").addObject("denuncias", denunciaService.listar());
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Ocorrencia denuncia)
	{
		denuncia.setStatus("Finalizada");
		return new ModelAndView("redirect:/denuncias");
	}

	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo)
	{
		denunciaService.remover(codigo);
		return new ModelAndView("redirect:/denuncias");
	}
	@GetMapping("/pesquisarCa")
	public ModelAndView getCA(String nomePesquisa)
	{
		ModelAndView mv=new ModelAndView("denuncias/pesquisa");
		mv.addObject("denuncias", denunciaService.pesquisarNome(nomePesquisa));
		return mv;
	}
	
	

}





