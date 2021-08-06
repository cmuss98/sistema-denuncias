package com.comercial.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
	@Query(value="Select * from usuario u join perfil p where u.codigo_perfil=p.codigo"
			+ " and  u.user like %:user%", nativeQuery=true)
	List<Usuario> findCaByName(@Param("user")String user);

}
