package com.comercial.domain.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Contacto 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long codigo;
	
	private String numero;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "codigo_proprietario")
	private Proprietario proprietario;
	
	@ManyToOne
	@JoinColumn(name = "codigo_funcionario")
	private Funcionario funcionario;
}
