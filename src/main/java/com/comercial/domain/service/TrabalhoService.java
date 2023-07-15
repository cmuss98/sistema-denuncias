package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Trabalho;
import com.comercial.domain.repository.TrabalhoRepository;


@Service
public class TrabalhoService 
{
	@Autowired
	private TrabalhoRepository trabalhoRepository;
	
	@Transactional
	public Trabalho salvar(Trabalho trabalho)
	{
		return trabalhoRepository.save(trabalho);
	}
	
	public Optional<Trabalho> buscar(Long codigo)
	{
		return trabalhoRepository.findById(codigo);
	}
	
	public List<Trabalho> listar()
	{
		return trabalhoRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		trabalhoRepository.deleteById(codigo);
	}
	public List<Trabalho> pesquisarNome(String descricao)
	{
		return trabalhoRepository.findCaByName(descricao);
	}
}
