package com.comercial.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long codigo;
	
	private String nome;
	
	private String genero;
	
	private String tipoDocumento;
	
	private String numeroDocumento;
	
	@Column(name = "telef")
	private String telefone;
	
	private String email;

	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String dataNascimento;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
	private LocalDate dataReserva;
	
	@OneToOne
	@JoinColumn(name = "codigo_voo")
	private Voo voo;
	
	@OneToOne
	@JoinColumn(name = "codigo_nacionalidade", nullable = false)
	private Nacionalidade nacionalidade;
	

	
}