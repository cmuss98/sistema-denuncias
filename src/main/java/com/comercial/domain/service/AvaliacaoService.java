package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Avaliacao;
import com.comercial.domain.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService 
{
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Transactional
	public Avaliacao salvar(Avaliacao avaliacao)
	{
		avaliacao.setDescricao("Nao Vista");
		return avaliacaoRepository.save(avaliacao);
	}
	
	public Optional<Avaliacao> buscar(Long codigo)
	{
		return avaliacaoRepository.findById(codigo);
	}
	
	public List<Avaliacao> listar()
	{
		return avaliacaoRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		avaliacaoRepository.deleteById(codigo);
	}
	public List<Avaliacao> pesquisarNome(String descricao)
	{
		return avaliacaoRepository.findCaByName(descricao);
	}
}
