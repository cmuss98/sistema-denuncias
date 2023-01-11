package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long>{
	@Query(value="Select * from contacto c join proprietario p join funcionario f"
			+ "where c.codigo_proprietario=p.codigo and c.codigo_funcionario=f.codigo"
			+ "and c.numero like %:numero%", nativeQuery=true)
List<Contacto> findCaByName(@Param("numero")String numero);
}
