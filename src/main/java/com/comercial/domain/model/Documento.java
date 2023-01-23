package com.comercial.domain.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="documento")
public class Documento 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long codigo;
	
	private String numero;
	@Column(name="datavalidade")
	private Date dataValidade;

	@Column(name="dataemissao")
	private Date dataEmissao;

	
	
	@ManyToOne
	@JoinColumn(name = "codigo_tipoDocumento")
	private TipoDocumento tipoDocumento;
}
