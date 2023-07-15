package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Ocorrencia;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long>{
	@Query(value="Select * from ocorrencia d join rota r where"
			+ " d.codigo_rota=r.codigo and"
			+ "d.status like %:status%", nativeQuery=true)
	List<Ocorrencia> findCaByName(@Param("status")String status);
}
