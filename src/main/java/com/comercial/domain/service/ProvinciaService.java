package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Provincia;
import com.comercial.domain.repository.ProvinciaRepository;



@Service
public class ProvinciaService 
{
	@Autowired
	private ProvinciaRepository provinciaRepository;
	
	@Transactional
	public Provincia salvar(Provincia provincia)
	{
		return provinciaRepository.save(provincia);
	}
	
	public Optional<Provincia> buscar(Long codigo)
	{
		return provinciaRepository.findById(codigo);
	}
	
	public List<Provincia> listar()
	{
		return provinciaRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		provinciaRepository.deleteById(codigo);
	}
}
