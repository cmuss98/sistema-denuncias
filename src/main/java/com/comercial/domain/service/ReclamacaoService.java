package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Reclamacao;
import com.comercial.domain.repository.ReclamacaoRepository;


@Service
public class ReclamacaoService 
{
	@Autowired
	private ReclamacaoRepository reclamacaoRepository;
	
	@Transactional
	public Reclamacao salvar(Reclamacao reclamacao)
	{
		reclamacao.setStatus("Pendente");
		return reclamacaoRepository.save(reclamacao);
	}
	
	public Optional<Reclamacao> buscar(Long codigo)
	{
		return reclamacaoRepository.findById(codigo);
	}
	
	public List<Reclamacao> listar()
	{
		return reclamacaoRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		reclamacaoRepository.deleteById(codigo);
	}
	public List<Reclamacao> pesquisarNome(String status)
	{
		return reclamacaoRepository.findCaByName(status);
	}
}
