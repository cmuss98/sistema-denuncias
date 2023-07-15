package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Ocorrencia;
import com.comercial.domain.repository.OcorrenciaRepository;

@Service
public class OcorrenciaService 
{
	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Transactional
	public Ocorrencia salvar(Ocorrencia ocorrencia)
	{
		ocorrencia.setStatus("Pendente");
		return ocorrenciaRepository.save(ocorrencia);
	}
	
	public Optional<Ocorrencia> buscar(Long codigo)
	{
		return ocorrenciaRepository.findById(codigo);
	}
	
	public List<Ocorrencia> listar()
	{
		return ocorrenciaRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		ocorrenciaRepository.deleteById(codigo);
	}
	public List<Ocorrencia> pesquisarNome(String status)
	{
		return ocorrenciaRepository.findCaByName(status);
	}
}
