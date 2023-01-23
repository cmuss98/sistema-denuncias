package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Proprietario;
import com.comercial.domain.model.Rota;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long>{
	@Query(value="Select * from Proprietario r join veiculo v join morada m join documento d where" 
			+ " r.codigo_veiculo=v.codigo and r.codigo_morada=m.morada and r.codigo_documento=d.documento"
			+ "and  r.nome like %:nome%", nativeQuery=true)
List<Proprietario> findCaByName(@Param("nome")String nome);
}
