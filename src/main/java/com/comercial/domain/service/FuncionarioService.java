package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.comercial.domain.model.Funcionario;
import com.comercial.domain.repository.FuncionarioRepository;

@Service
public class FuncionarioService 
{
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Transactional
	public Funcionario salvar(Funcionario funcionario)
	{
		return funcionarioRepository.save(funcionario);
	}
	
	public Optional<Funcionario> buscar(Long codigo)
	{
		return funcionarioRepository.findById(codigo);
	}
	
	public List<Funcionario> listar()
	{
		return funcionarioRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		funcionarioRepository.deleteById(codigo);
	}
	
	public List<Funcionario> pesquisarNome(String nome)
	{
		return funcionarioRepository.findCaByName(nome);
	}
}
