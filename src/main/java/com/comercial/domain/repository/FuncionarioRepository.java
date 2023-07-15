package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>
{
	@Query(value="Select * from funcionario u join usuario m join trabalho t join documento d join rota r "
			+ " where u.codigo_usuario=m.codigo and u.codigo_trabalho=t.codigo and"
			+ " u.codigo_documento=d.codigo and u.codigo_rota=r.codigo and u.nome like %:nome%", nativeQuery=true)
	List<Funcionario> findCaByName(@Param("nome")String nome);

}
