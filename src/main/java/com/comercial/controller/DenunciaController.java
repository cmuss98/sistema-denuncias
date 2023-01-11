package com.comercial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.domain.model.Denuncia;
import com.comercial.domain.service.AvaliacaoService;
import com.comercial.domain.service.DenunciaService;
import com.comercial.domain.service.VeiculoService;



@Controller
@RequestMapping("/denuncias")
public class DenunciaController 
{
	@Autowired
	private DenunciaService denunciaService;
	@Autowired
	private VeiculoService veiculoService;
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@GetMapping("/novo")
	public ModelAndView novo(Denuncia denuncia)
	{
		ModelAndView mv=new ModelAndView("denuncias/cadastro");
		mv.addObject("veiculos",veiculoService.listar());
		mv.addObject("avaliacoes", avaliacaoService.listar());
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(Denuncia denuncia, RedirectAttributes attributes)
	{
		denunciaService.salvar(denuncia);
		attributes.addFlashAttribute("mensagem", String.format("Denuncia de veiculo %s cadastrado com sucesso", denuncia.getVeiculo()));
		return new ModelAndView("redirect:/denuncias/novo");
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		return new ModelAndView("denuncias/pesquisa").addObject("denuncias", denunciaService.listar());
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Denuncia denuncia)
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





