package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	@Query(value="Select * from cliente c join voo v where c.codigo_voo=v.codigo and"
			+ " c.nome like %:nome%", nativeQuery=true)
	List<Cliente> findCaByName(@Param("nome")String nome);

}
