package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Licenca;
import com.comercial.domain.model.Rota;

@Repository
public interface LicencaRepository extends JpaRepository<Licenca, Long>{
	@Query(value="Select * from Licenca l where" 
			+ "l.numero like %:numero%", nativeQuery=true)
List<Licenca> findCaByName(@Param("numero")String numero);
}
