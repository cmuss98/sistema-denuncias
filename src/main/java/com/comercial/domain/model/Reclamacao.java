package com.comercial.domain.model;



import java.sql.Time;
import java.util.Date;

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
public class Reclamacao 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long codigo;

	private String status;
	
	private String descricao;
	
	private Date data;
	
	private Time hora;
	
	private String matricula;
	
	@ManyToOne
	@JoinColumn(name = "codigo_denunciante")
	private Denunciante denunciante;
	
	@ManyToOne
	@JoinColumn(name = "codigo_rota")
	private Rota rota;
}
