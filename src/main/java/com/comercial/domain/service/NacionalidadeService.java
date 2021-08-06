package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Nacionalidade;
import com.comercial.domain.repository.NacionalidadeRepository;

@Service
public class NacionalidadeService 
{
	@Autowired
	private NacionalidadeRepository nacionalidadeRepository;
	
	@Transactional
	public Nacionalidade salvar(Nacionalidade nacionalidade)
	{
		return nacionalidadeRepository.save(nacionalidade);
	}
	
	public Optional<Nacionalidade> buscar(Long codigo)
	{
		return nacionalidadeRepository.findById(codigo);
	}
	
	public List<Nacionalidade> listar()
	{
		return nacionalidadeRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		nacionalidadeRepository.deleteById(codigo);
	}
}