package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.CompanhiaAerea;
import com.comercial.domain.repository.CompanhiaAereaRepository;

@Service
public class CompanhiaAereaService 
{
	@Autowired
	private CompanhiaAereaRepository companhiaAereaRepository;
	
	@Transactional
	public CompanhiaAerea salvar(CompanhiaAerea companhiaAerea)
	{
		return companhiaAereaRepository.save(companhiaAerea);
	}
	
	public Optional<CompanhiaAerea> buscar(Long codigo)
	{
		return companhiaAereaRepository.findById(codigo);
	}
	
	public List<CompanhiaAerea> listar()
	{
		return companhiaAereaRepository.findAll();
	}
	public List<CompanhiaAerea> pesquisarNome(String nome)
	{
		return companhiaAereaRepository.findCaByName(nome);
	}
	
	@Transactional
	public void remove(Long codigo)
	{
		companhiaAereaRepository.deleteById(codigo);
	}
}