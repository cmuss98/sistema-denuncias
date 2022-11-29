package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.CoresBarra;


@Repository
public interface CoresBarraRepository extends JpaRepository<CoresBarra, Long>{
	@Query(value="Select * from cores_barra a where a.cor like %:cor%", nativeQuery=true)
	List<CoresBarra> findCaByName(@Param("cor")String cor);
}

