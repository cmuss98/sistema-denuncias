package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.TipoDocumento;
import com.comercial.domain.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoService 
{
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	@Transactional
	public TipoDocumento salvar(TipoDocumento tipoDocumento)
	{
		return tipoDocumentoRepository.save(tipoDocumento);
	}
	
	public Optional<TipoDocumento> buscar(Long codigo)
	{
		return tipoDocumentoRepository.findById(codigo);
	}
	
	public List<TipoDocumento> listar()
	{
		return tipoDocumentoRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		tipoDocumentoRepository.deleteById(codigo);
	}
	public List<TipoDocumento> pesquisarNome(String descricao)
	{
		return tipoDocumentoRepository.findCaByName(descricao);
	}
}
