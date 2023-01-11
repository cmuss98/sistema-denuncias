package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Reclamacao;

@Repository
public interface ReclamacaoRepository extends JpaRepository<Reclamacao, Long>{
	@Query(value="Select * from reclamacao r join veiculo cb where" 
			+ " r.codigo_veiculo=cb.codigo and  r.status like %:status%", nativeQuery=true)
List<Reclamacao> findCaByName(@Param("status")String status);
}