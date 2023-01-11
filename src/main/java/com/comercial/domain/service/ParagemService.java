package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Paragem;
import com.comercial.domain.repository.ParagemRepository;


@Service
public class ParagemService 
{
	@Autowired
	private ParagemRepository paragemRepository;
	
	@Transactional
	public Paragem salvar(Paragem paragem)
	{
		return paragemRepository.save(paragem);
	}
	
	public Optional<Paragem> buscar(Long codigo)
	{
		return paragemRepository.findById(codigo);
	}
	
	public List<Paragem> listar()
	{
		return paragemRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		paragemRepository.deleteById(codigo);
	}
	public List<Paragem> pesquisarNome(String descricao)
	{
		return paragemRepository.findCaByName(descricao);
	}
}
