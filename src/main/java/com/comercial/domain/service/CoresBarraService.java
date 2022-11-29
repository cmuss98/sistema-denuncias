package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.CoresBarra;
import com.comercial.domain.repository.CoresBarraRepository;

@Service
public class CoresBarraService 
{
	@Autowired
	private CoresBarraRepository coresBarraRepository;
	
	@Transactional
	public CoresBarra salvar(CoresBarra coresBarra)
	{
		return coresBarraRepository.save(coresBarra);
	}
	
	public Optional<CoresBarra> buscar(Long codigo)
	{
		return coresBarraRepository.findById(codigo);
	}
	
	public List<CoresBarra> listar()
	{
		return coresBarraRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		coresBarraRepository.deleteById(codigo);
	}
}