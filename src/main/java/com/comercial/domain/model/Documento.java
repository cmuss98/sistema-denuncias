package com.comercial.domain.model;



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
public class Documento 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private long codigo;
	
	private String numero;
	
	private Date dataValidade;
	
	private Date dataEmissao;

	
	
	@ManyToOne
	@JoinColumn(name = "codigo_tipoDocumento")
	private TipoDocumento tipoDocumento;
	
	@ManyToOne
	@JoinColumn(name = "codigo_veiculo")
	private Veiculo veiculo;
	
	@ManyToOne
	@JoinColumn(name = "codigo_proprietario")
	private Proprietario proprietario;
}
