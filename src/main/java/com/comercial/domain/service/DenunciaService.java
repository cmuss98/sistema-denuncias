package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Denuncia;
import com.comercial.domain.repository.DenunciaRepository;

@Service
public class DenunciaService 
{
	@Autowired
	private DenunciaRepository denunciaRepository;
	
	@Transactional
	public Denuncia salvar(Denuncia denuncia)
	{
		denuncia.setStatus("Pendente");
		return denunciaRepository.save(denuncia);
	}
	
	public Optional<Denuncia> buscar(Long codigo)
	{
		return denunciaRepository.findById(codigo);
	}
	
	public List<Denuncia> listar()
	{
		return denunciaRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		denunciaRepository.deleteById(codigo);
	}
	public List<Denuncia> pesquisarNome(String status)
	{
		return denunciaRepository.findCaByName(status);
	}
}
