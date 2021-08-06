package com.comercial.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.comercial.domain.service.VooService;



@Controller
@RequestMapping("/bilhetes")
public class BilheteController 
{
	@Autowired
	private VooService vooService;
	
	@GetMapping("/novo")
	public ModelAndView novo()
	{
		return new ModelAndView("bilhetes/cadastro").addObject("voos",vooService.listar());
	}
	@GetMapping("/pesquisarCa")
	public ModelAndView getCA(String nomePesquisa)
	{
		ModelAndView mv=new ModelAndView("bilhetes/cadastro");
		mv.addObject("voos", vooService.pesquisarNome(nomePesquisa));
		return mv;
	}
	
	
	

}

