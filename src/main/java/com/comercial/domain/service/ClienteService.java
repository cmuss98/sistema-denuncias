package com.comercial.domain.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Cliente;
import com.comercial.domain.model.CompanhiaAerea;
import com.comercial.domain.repository.ClienteRepository;

@Service
public class ClienteService 
{
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente)
	{
		cliente.setDataReserva(LocalDate.now());
		return clienteRepository.save(cliente);
	}
	
	public Optional<Cliente> buscar(Long codigo)
	{
		return clienteRepository.findById(codigo);
	}
	
	public List<Cliente> listar()
	{
		return clienteRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		clienteRepository.deleteById(codigo);
	}
	public List<Cliente> pesquisarNome(String nome)
	{
		return clienteRepository.findCaByName(nome);
	}
}