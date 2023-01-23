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
import com.comercial.domain.model.Proprietario;
import com.comercial.domain.service.ContactoService;
import com.comercial.domain.service.DocumentoService;
import com.comercial.domain.service.FuncionarioService;
import com.comercial.domain.service.MoradaService;
import com.comercial.domain.service.ProprietarioService;
import com.comercial.domain.service.TipoDocumentoService;
import com.comercial.domain.service.TrabalhoService;

@Controller
@RequestMapping("/proprietarios")
public class ProprietarioController 
{
	@Autowired
	private ProprietarioService proprietarioService;
	
	@Autowired
	private MoradaService moradaService;
	
	@Autowired
	private DocumentoService documentoService;
	
	@Autowired
	private TipoDocumentoService tipoDocumentoService;

	@Autowired
	private ContactoService contactoService;
	
	
	@GetMapping("/novo")
	public ModelAndView novo(Proprietario proprietario)
	{
		ModelAndView mv=new ModelAndView("proprietarios/cadastro");
		mv.addObject("moradas", moradaService.listar());
		mv.addObject("contactos", contactoService.listar());
		mv.addObject("documentos", documentoService.listar());
		mv.addObject("tipoDocumentos", tipoDocumentoService.listar());
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(Proprietario proprietario, RedirectAttributes attributes)
	{
		proprietarioService.salvar(proprietario);
		attributes.addFlashAttribute("mensagem", String.format("Proprietario de nome %s cadastrado com sucesso", proprietario.getNome()));
		return new ModelAndView("redirect:/proprietarios/novo");
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		return new ModelAndView("proprietarios/pesquisa").addObject("proprietarios", proprietarioService.listar());
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Proprietario proprietario, RedirectAttributes attributes)
	{
		attributes.addFlashAttribute("proprietario", proprietario);
		return new ModelAndView("redirect:/proprietarios/novo");
	}

	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo)
	{
		proprietarioService.remover(codigo);
		return new ModelAndView("redirect:/proprietarios");
	}
	@GetMapping("/pesquisarCa")
	public ModelAndView getCA(String nomePesquisa)
	{
		ModelAndView mv=new ModelAndView("proprietarios/pesquisa");
		mv.addObject("proprietarios", proprietarioService.pesquisarNome(nomePesquisa));
		return mv;
	}

}


