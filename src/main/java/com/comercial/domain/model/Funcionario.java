package com.comercial.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Funcionario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private long codigo;
	
	private String nome;
	
	private Date dataNascimento;
	
	private String genero;
	
	private String avenida;
	
	private String casa;
	
	private String bairro;
	
	private String contacto;
	
	
	@OneToOne
	@JoinColumn(name = "codigo_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "codigo_trabalho")
	private Trabalho trabalho;
	
	@OneToOne
	@JoinColumn(name = "codigo_documento")
	private Documento documento;
	
	@ManyToOne
	@JoinColumn(name = "codigo_rota")
	private Rota rota;
	
	
}
