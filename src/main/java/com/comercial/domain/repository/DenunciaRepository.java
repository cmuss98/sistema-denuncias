package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Denuncia;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long>{
	@Query(value="Select * from denuncia d join denunciante de  join rota r where"
			+ " d.codigo_denunciante=de.codigo and d.codigo_rota=r.codigo"
			+ "d.status like %:status%", nativeQuery=true)
	List<Denuncia> findCaByName(@Param("status")String status);
}
