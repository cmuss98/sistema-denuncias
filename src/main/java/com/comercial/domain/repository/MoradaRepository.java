package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Morada;
import com.comercial.domain.model.Rota;

@Repository
public interface MoradaRepository extends JpaRepository<Morada, Long>{
	@Query(value="Select * from morada r where" 
			+ "   r.bairro like %:bairro%", nativeQuery=true)
List<Morada> findCaByName(@Param("bairro")String bairro);
}
