package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.CorBarra;


@Repository
public interface CorBarraRepository extends JpaRepository<CorBarra, Long>{
	@Query(value="Select * from corBarra a where a.cor like %:cor%", nativeQuery=true)
	List<CorBarra> findCaByName(@Param("cor")String cor);
}

