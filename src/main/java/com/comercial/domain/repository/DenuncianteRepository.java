package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Denunciante;
import com.comercial.domain.model.Rota;

@Repository
public interface DenuncianteRepository extends JpaRepository<Denunciante, Long>{
	@Query(value="Select * from denunciante d where" 
			+ "   d.nome like %:nome%", nativeQuery=true)
List<Denunciante> findCaByName(@Param("nome")String nome);
}
