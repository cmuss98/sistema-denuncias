package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Dirrecao;
import com.comercial.domain.repository.DirrecaoRepository;


@Service
public class DirrecaoService 
{
	@Autowired
	private DirrecaoRepository dirrecaoRepository;
	
	@Transactional
	public Dirrecao salvar(Dirrecao dirrecao)
	{
		return dirrecaoRepository.save(dirrecao);
	}
	
	public Optional<Dirrecao> buscar(Long codigo)
	{
		return dirrecaoRepository.findById(codigo);
	}
	
	public List<Dirrecao> listar()
	{
		return dirrecaoRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		dirrecaoRepository.deleteById(codigo);
	}
	public List<Dirrecao> pesquisarNome(String descricao)
	{
		return dirrecaoRepository.findCaByName(descricao);
	}
}
