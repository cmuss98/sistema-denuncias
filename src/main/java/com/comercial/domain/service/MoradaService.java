package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Morada;
import com.comercial.domain.repository.MoradaRepository;


@Service
public class MoradaService 
{
	@Autowired
	private MoradaRepository moradaRepository;
	
	@Transactional
	public Morada salvar(Morada morada)
	{
		return moradaRepository.save(morada);
	}
	
	public Optional<Morada> buscar(Long codigo)
	{
		return moradaRepository.findById(codigo);
	}
	
	public List<Morada> listar()
	{
		return moradaRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		moradaRepository.deleteById(codigo);
	}
	public List<Morada> pesquisarNome(String bairro)
	{
		return moradaRepository.findCaByName(bairro);
	}
}
