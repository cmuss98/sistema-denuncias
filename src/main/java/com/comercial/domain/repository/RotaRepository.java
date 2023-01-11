package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Rota;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long>{
	@Query(value="Select * from rota r join corBarra cb where" 
					+ " r.codigo_cor=cb.codigo and  r.via like %:via%", nativeQuery=true)
	List<Rota> findCaByName(@Param("via")String via);
}
