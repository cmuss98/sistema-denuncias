package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Contacto;
import com.comercial.domain.repository.ContactoRepository;

@Service
public class ContactoService 
{
	@Autowired
	private ContactoRepository contactoRepository;
	
	@Transactional
	public Contacto salvar(Contacto contacto)
	{
		return contactoRepository.save(contacto);
	}
	
	public Optional<Contacto> buscar(Long codigo)
	{
		return contactoRepository.findById(codigo);
	}
	
	public List<Contacto> listar()
	{
		return contactoRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		contactoRepository.deleteById(codigo);
	}
	public List<Contacto> pesquisarNome(String numero)
	{
		return contactoRepository.findCaByName(numero);
	}
}
