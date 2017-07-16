package com.emervel.service;

import com.emervel.dominio.ListaProductos;
import com.emervel.dominio.Producto;
import com.emervel.dominio.UsuarioProducto;
import com.emervel.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guopm on 22/06/2017.
 */
@Service
public class ProductoServicio {
    private ProductoRepository productoRepository;

    @Autowired
    public ProductoServicio(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }


    public List<Producto> productosUsuario(String login) {
        return productoRepository.findAllProductosUsuarioByLogin(login);
    }

    public List<ListaProductos> productosEnListaUsuario(String login, List<Producto> productos) {
        List<ListaProductos> listaProductos = new ArrayList<ListaProductos>();
        List<Integer> nProductos = productoRepository.findNumeroProductosByLogin(login);
        if (null != productos && null != nProductos && productos.size() == nProductos.size()) {
            for (int i = 0 ; i <  productos.size() ; i++ ) {
                int j = nProductos.get(i);
                if (j > 0) {
                    ListaProductos listaProducto = new ListaProductos();
                    listaProducto.setProducto(productos.get(i));
                    listaProducto.setCantidad(j);
                    listaProductos.add(listaProducto);
                }
            }
        }
        return listaProductos;
    }

}
