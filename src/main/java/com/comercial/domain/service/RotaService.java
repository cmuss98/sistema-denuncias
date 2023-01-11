package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Rota;
import com.comercial.domain.repository.RotaRepository;

@Service
public class RotaService 
{
	@Autowired
	private RotaRepository rotaRepository;
	
	@Transactional
	public Rota salvar(Rota rota)
	{
		return rotaRepository.save(rota);
	}
	
	public Optional<Rota> buscar(Long codigo)
	{
		return rotaRepository.findById(codigo);
	}
	
	public List<Rota> listar()
	{
		return rotaRepository.findAll();
	}
	public List<Rota> pesquisarNome(String via)
	{
		return rotaRepository.findCaByName(via);
	}
	
	@Transactional
	public void remove(Long codigo)
	{
		rotaRepository.deleteById(codigo);
	}
}