package com.comercial.domain.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Veiculo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long codigo;
	
	private String matricula;
	
	private String nome;
	
	@Column (name="nr_doc")
	private String nrDoc;
	
	@Column (name="tipo_doc")
	private String tipoDoc;
	
	private String telefone1;
	
	private String telefone2;
	
	private String bairro;
	
	private String avenida;
	
	private String quarteirao;
	@Column (name="nr_casa")
	private String nrCasa;

	@ManyToOne
	@JoinColumn(name = "codigo_rota")
	private Rota rota;
	

	
}