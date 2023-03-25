package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Denunciante;
import com.comercial.domain.repository.DenuncianteRepository;


@Service
public class DenuncianteService 
{
	@Autowired
	private DenuncianteRepository denuncianteRepository;
	
	@Transactional
	public Denunciante salvar(Denunciante denunciante)
	{
		return denuncianteRepository.save(denunciante);
	}
	
	public Optional<Denunciante> buscar(Long codigo)
	{
		return denuncianteRepository.findById(codigo);
	}
	
	public List<Denunciante> listar()
	{
		return denuncianteRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		denuncianteRepository.deleteById(codigo);
	}
	public List<Denunciante> pesquisarNome(String descricao)
	{
		return denuncianteRepository.findCaByName(descricao);
	}
}
