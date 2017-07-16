package com.emervel.dominio;

import lombok.Data;

import java.util.Date;

/**
 * Created by guopm on 28/06/2017.
 */
@Data
public class ListaProductos {
    private Producto producto;
    private Date ultimaModificacion;
    private Integer cantidad;
}
