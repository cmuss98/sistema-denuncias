package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.comercial.domain.model.Perfil;
import com.comercial.domain.repository.PerfilRepository;

@Service
public class PerfilService 
{
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Transactional
	public Perfil salvar(Perfil perfil)
	{
		return perfilRepository.save(perfil);
	}
	
	public Optional<Perfil> buscar(Long codigo)
	{
		return perfilRepository.findById(codigo);
	}
	
	public List<Perfil> listar()
	{
		return perfilRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		perfilRepository.deleteById(codigo);
	}
}
