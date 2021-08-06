package com.comercial.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode( onlyExplicitlyIncluded = true)
public class Voo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long codigo;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate data;
	
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
	private LocalTime horaPartida;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
	private LocalTime horaChegada;
	
	private BigDecimal preco;
	
	@OneToOne
	@JoinColumn(name = "codigo_aeronave", nullable = false)
	private Aeronave aeronave;
	
	@ManyToMany
	@JoinTable(name="voopro",
		joinColumns= {@JoinColumn(name = "codigo_voo")},
		inverseJoinColumns= {@JoinColumn(name = "codigo_provincia")}
	)
	private List<Provincia> provincia;

}
