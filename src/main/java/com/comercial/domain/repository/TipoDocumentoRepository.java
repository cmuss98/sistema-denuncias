package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.TipoDocumento;


@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long>{
	@Query(value="Select * from TipoDocumento r where" 
			+ "  r.descricao like %:descricao%", nativeQuery=true)
List<TipoDocumento> findCaByName(@Param("descricao")String descricao);
}
