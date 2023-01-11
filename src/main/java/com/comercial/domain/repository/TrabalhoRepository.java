package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Trabalho;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>{
	@Query(value="Select * from Trabalho r where r.dirrecao like %:dirrecao%", nativeQuery=true)
List<Trabalho> findCaByName(@Param("dirrecao")String dirrecao);
}