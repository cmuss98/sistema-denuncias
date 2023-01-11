package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Documento;
import com.comercial.domain.repository.DocumentoRepository;

@Service
public class DocumentoService 
{
	@Autowired
	private DocumentoRepository documentoRepository;
	
	@Transactional
	public Documento salvar(Documento documento)
	{
		return documentoRepository.save(documento);
	}
	
	public Optional<Documento> buscar(Long codigo)
	{
		return documentoRepository.findById(codigo);
	}
	
	public List<Documento> listar()
	{
		return documentoRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		documentoRepository.deleteById(codigo);
	}
	public List<Documento> pesquisarNome(String numero)
	{
		return documentoRepository.findCaByName(numero);
	}
}
