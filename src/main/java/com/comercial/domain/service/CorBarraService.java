package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.CorBarra;
import com.comercial.domain.repository.CorBarraRepository;

@Service
public class CorBarraService 
{
	@Autowired
	private CorBarraRepository corBarraRepository;
	
	@Transactional
	public CorBarra salvar(CorBarra corBarra)
	{
		return corBarraRepository.save(corBarra);
	}
	
	public Optional<CorBarra> buscar(Long codigo)
	{
		return corBarraRepository.findById(codigo);
	}
	
	public List<CorBarra> listar()
	{
		return corBarraRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		corBarraRepository.deleteById(codigo);
	}
}