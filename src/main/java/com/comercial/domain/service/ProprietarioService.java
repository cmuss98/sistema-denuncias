package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Proprietario;
import com.comercial.domain.repository.ProprietarioRepository;


@Service
public class ProprietarioService 
{
	@Autowired
	private ProprietarioRepository proprietarioRepository;
	
	@Transactional
	public Proprietario salvar(Proprietario proprietario)
	{
		return proprietarioRepository.save(proprietario);
	}
	
	public Optional<Proprietario> buscar(Long codigo)
	{
		return proprietarioRepository.findById(codigo);
	}
	
	public List<Proprietario> listar()
	{
		return proprietarioRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		proprietarioRepository.deleteById(codigo);
	}
	public List<Proprietario> pesquisarNome(String nome)
	{
		return proprietarioRepository.findCaByName(nome);
	}
}
