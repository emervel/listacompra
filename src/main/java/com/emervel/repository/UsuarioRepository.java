package com.emervel.repository;

import com.emervel.dominio.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Usuario findByLogin(String login);
}
