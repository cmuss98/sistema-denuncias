package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Voo;
import com.comercial.domain.repository.VooRepository;

@Service
public class VooService 
{
	@Autowired
	private VooRepository vooRepository;
	
	@Transactional
	public Voo salvar(Voo voo)
	{
		return vooRepository.save(voo);
	}
	
	public Optional<Voo> buscar(Long codigo)
	{
		return vooRepository.findById(codigo);
	}
	
	public List<Voo> listar()
	{
		return vooRepository.findAll();
	}
	
	@Transactional
	public void remove(Long codigo)
	{
		vooRepository.deleteById(codigo);
	}
	
	public List<Voo> pesquisarNome(String nome)
	{
		return vooRepository.findCaByName(nome);
	}
}
