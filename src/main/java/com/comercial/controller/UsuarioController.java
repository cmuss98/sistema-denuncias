package com.comercial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.domain.model.Usuario;
import com.comercial.domain.service.PerfilService;
import com.comercial.domain.service.UsuarioService;

@Controller
@RequestMapping("/funcionarios")
public class UsuarioController 
{
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PerfilService perfilService;
	
	@GetMapping("/novo")
	public ModelAndView novo(Usuario usuario)
	{
		return new ModelAndView("funcionarios/cadastro").addObject("perfis",perfilService.listar());
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(Usuario usuario, RedirectAttributes attributes)
	{
		usuarioService.salvar(usuario);
		attributes.addFlashAttribute("mensagem", "Usuario cadastrado com sucesso");
		return new ModelAndView("redirect:/funcionarios/novo");
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		return new ModelAndView("funcionarios/pesquisa").addObject("usuarios", usuarioService.listar());
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Usuario usuario, RedirectAttributes attributes)
	{
		attributes.addFlashAttribute("usuario", usuario);
		return new ModelAndView("redirect:/funcionarios/novo");
	}

	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo)
	{
		usuarioService.remover(codigo);
		return new ModelAndView("redirect:/funcionarios");
	}
	@GetMapping("/pesquisarCa")
	public ModelAndView getCA(String nomePesquisa)
	{
		ModelAndView mv=new ModelAndView("funcionarios/pesquisa");
		mv.addObject("usuarios", usuarioService.pesquisarNome(nomePesquisa));
		return mv;
	}

}


