package com.emervel.repository;

import com.emervel.dominio.Producto;
import com.emervel.dominio.Supermercado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//List<Post> findAllByAuthorIdOrderByPostedOnDesc(Long id);

@Repository
public interface SupermercadoRepository extends CrudRepository<Supermercado, Long> {

	List<Supermercado> findAllByUsuariosLoginOrderByMarca(String login);

}
