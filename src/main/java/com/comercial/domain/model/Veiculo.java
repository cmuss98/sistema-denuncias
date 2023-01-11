package com.comercial.domain.model;




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
	private long codigo;
	
	private String matricula;
	
	private String cor;

	@ManyToOne
	@JoinColumn(name = "codigo_rota")
	private Rota rota;
	
	@OneToOne
	@JoinColumn(name = "codigo_licenca")
	private Licenca licenca;
	
	
	

	
}