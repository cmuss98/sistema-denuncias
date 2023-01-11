package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Denuncia;
import com.comercial.domain.model.Licenca;
import com.comercial.domain.repository.DenunciaRepository;
import com.comercial.domain.repository.LicencaRepository;

@Service
public class LicencaService 
{
	@Autowired
	private LicencaRepository licencaRepository;
	
	@Transactional
	public Licenca salvar(Licenca licenca)
	{
		return licencaRepository.save(licenca);
	}
	
	public Optional<Licenca> buscar(Long codigo)
	{
		return licencaRepository.findById(codigo);
	}
	
	public List<Licenca> listar()
	{
		return licencaRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		licencaRepository.deleteById(codigo);
	}
	public List<Licenca> pesquisarNome(String numero)
	{
		return licencaRepository.findCaByName(numero);
	}
}
