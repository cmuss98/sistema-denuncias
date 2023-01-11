package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	@Query(value="Select * from veiculo v join rota r join licenca l where v.codigo_rota=r.codigo and"
			+ "v.codigo_licenca=l.codigo and v.matricula like %:matricula%", nativeQuery=true)
	List<Veiculo> findCaByName(@Param("matricula")String matricula);

}
