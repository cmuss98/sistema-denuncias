package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Veiculo;
import com.comercial.domain.repository.VeiculoRepository;

@Service
public class VeiculoService 
{
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Transactional
	public Veiculo salvar(Veiculo veiculo)
	{
		return veiculoRepository.save(veiculo);
	}
	
	public Optional<Veiculo> buscar(Long codigo)
	{
		return veiculoRepository.findById(codigo);
	}
	
	public List<Veiculo> listar()
	{
		return veiculoRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		veiculoRepository.deleteById(codigo);
	}
	public List<Veiculo> pesquisarNome(String matricula)
	{
		return veiculoRepository.findCaByName(matricula);
	}
}