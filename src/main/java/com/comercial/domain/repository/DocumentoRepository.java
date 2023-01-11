package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long>{
	@Query(value="Select * from Documento d join tipoDocumento tp join veiculo v"
			+ " join proprietario p where d.codigo_tipoDocumento=tp.codigo and "
			+ "d.codigo_proprietario=p.codigo and d.codigo_veiculo=v.codigo"
			+ "and d.numero like %:numero%", nativeQuery=true)
List<Documento> findCaByName(@Param("numero")String numero);
}
