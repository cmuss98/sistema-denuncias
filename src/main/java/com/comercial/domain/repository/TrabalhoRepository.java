package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Trabalho;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>{
	@Query(value="Select * from Trabalho t join dirrecao r where t.codigo_dirrecao=r.codigo"
			+ " and t.descricao like %:descricao%", nativeQuery=true)
List<Trabalho> findCaByName(@Param("descricao")String dirrecao);
}