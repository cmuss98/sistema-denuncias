package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.CompanhiaAerea;
import com.comercial.domain.model.Usuario;
import com.comercial.domain.repository.UsuarioRepository;

@Service
public class UsuarioService 
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario salvar(Usuario usuario)
	{
		return usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> buscar(Long codigo)
	{
		return usuarioRepository.findById(codigo);
	}
	
	public List<Usuario> listar()
	{
		return usuarioRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		usuarioRepository.deleteById(codigo);
	}
	
	public List<Usuario> pesquisarNome(String user)
	{
		return usuarioRepository.findCaByName(user);
	}
}
