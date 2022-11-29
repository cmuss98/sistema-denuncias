package com.comercial.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.domain.model.Denuncia;

@Controller
@RequestMapping("/funcionario")
public class FuncionariosController 
{
	
	
	@GetMapping("")
	public ModelAndView novo()
	{
		return new ModelAndView("funcionario");
	}
	@PostMapping("/verificar")
	public ModelAndView verificar()
	{
		//denunciaService.salvar(denuncia);
	//	attributes.addFlashAttribute("mensagem", String.format("Denuncia de referencia %s cadastrado com sucesso", denuncia.getPontoreferencia()));
		return new ModelAndView("redirect:/principal");
	}
	

}


