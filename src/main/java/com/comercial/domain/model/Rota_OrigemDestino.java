package com.comercial.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table (name="rota_origemdestino")
public class Rota_OrigemDestino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "codigo_origemDestino")
	private OrigemDestino origemDestino;
	
	@ManyToOne
	@JoinColumn(name = "codigo_rota")
	private Rota rota;

}
