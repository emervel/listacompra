package com.emervel.repository;

import com.emervel.dominio.Producto;
import com.emervel.dominio.Usuario;
import com.emervel.dominio.UsuarioProducto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

	@Query(value = "SELECT PRODUCTO.* FROM PRODUCTO  INNER JOIN USUARIO_PRODUCTO ON PRODUCTO.ID_PRODUCTO=USUARIO_PRODUCTO.ID_PRODUCTO WHERE LOGIN=:login ORDER BY ID_PRODUCTO ASC ", nativeQuery = true)
	List<Producto> findAllProductosUsuarioByLogin(@Param("login") String login);

	@Query(value = "SELECT CANTIDAD FROM USUARIO_PRODUCTO WHERE LOGIN=:login ORDER BY ID_PRODUCTO ASC", nativeQuery = true)
	List<Integer> findNumeroProductosByLogin(@Param("login") String login);


}
