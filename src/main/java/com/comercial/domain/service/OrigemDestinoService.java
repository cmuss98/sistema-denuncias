package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.OrigemDestino;
import com.comercial.domain.repository.OrigemDestinoRepository;


@Service
public class OrigemDestinoService 
{
	@Autowired
	private OrigemDestinoRepository origemDestinoRepository;
	
	@Transactional
	public OrigemDestino salvar(OrigemDestino origemDestino)
	{
		return origemDestinoRepository.save(origemDestino);
	}
	
	public Optional<OrigemDestino> buscar(Long codigo)
	{
		return origemDestinoRepository.findById(codigo);
	}
	
	public List<OrigemDestino> listar()
	{
		return origemDestinoRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		origemDestinoRepository.deleteById(codigo);
	}
	public List<OrigemDestino> pesquisarNome(String descricao)
	{
		return origemDestinoRepository.findCaByName(descricao);
	}
}
