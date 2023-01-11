package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
	@Query(value="Select * from avaliacao a  where" 
			+ " a.descricao like %:descricao%", nativeQuery=true)
List<Avaliacao> findCaByName(@Param("descricao")String descricao);
}
