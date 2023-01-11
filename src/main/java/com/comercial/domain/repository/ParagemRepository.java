package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Paragem;
import com.comercial.domain.model.Rota;

@Repository
public interface ParagemRepository extends JpaRepository<Paragem, Long>{
	@Query(value="Select * from Paragem p join rota r where" 
			+ " p.codigo_rota=r.codigo and  p.descricao like %:descricao%", nativeQuery=true)
List<Paragem> findCaByName(@Param("descricao")String descricao);
}
