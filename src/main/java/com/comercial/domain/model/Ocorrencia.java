package com.comercial.domain.model;

import java.io.File;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ocorrencia 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long codigo;
	
	private String tipo;
	
	private String descricao;
	
	private String status;
	
	private String localizacao;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private Date data;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
	private LocalDateTime hora;
	
	private File foto;
	
	private String matricula;
	
	@ManyToOne
	@JoinColumn(name = "codigo_rota")
	private Rota rota;
}
