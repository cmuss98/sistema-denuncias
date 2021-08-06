package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Aeronave;

@Repository
public interface AeronaveRepository extends JpaRepository<Aeronave, Long>{
	@Query(value="Select * from aeronave a join companhia_aerea ca where"
			+ " a.codigo_companhia_area=ca.codigo and a.referencia like %:referencia%", nativeQuery=true)
	List<Aeronave> findCaByName(@Param("referencia")String referencia);
}
