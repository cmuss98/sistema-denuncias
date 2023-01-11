package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.OrigemDestino;

@Repository
public interface OrigemDestinoRepository extends JpaRepository<OrigemDestino, Long>{
	@Query(value="Select * from OrigemDestino r where" 
			+ " r.descricao like %:descricao%", nativeQuery=true)
List<OrigemDestino> findCaByName(@Param("descricao")String descricao);
}
