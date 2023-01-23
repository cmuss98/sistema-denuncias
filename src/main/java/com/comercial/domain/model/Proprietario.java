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
public class Proprietario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long codigo;
	
	private String nome;
	
	private Date dataNascimento;
	
	private String genero;
	
	@ManyToOne
	@JoinColumn(name = "codigo_morada")
	private Morada morada;
	
	@OneToOne
	@JoinColumn(name = "codigo_veiculo")
	private Veiculo veiculo;
	
	@OneToOne
	@JoinColumn(name = "codigo_documento")
	private Documento documento;
}
