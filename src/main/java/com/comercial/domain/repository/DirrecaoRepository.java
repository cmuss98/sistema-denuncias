package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Dirrecao;

@Repository
public interface DirrecaoRepository extends JpaRepository<Dirrecao, Long>{
	@Query(value="Select * from  dirrecao r where t.descricao like %:descricao%", nativeQuery=true)
List<Dirrecao> findCaByName(@Param("descricao")String dirrecao);
}