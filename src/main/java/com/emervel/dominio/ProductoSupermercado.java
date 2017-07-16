package com.emervel.dominio;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by guopm on 21/06/2017.
 */
@Entity
@Data
@Table( name = "producto_supermercado" )
public class ProductoSupermercado implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO")
    private Producto producto;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_SUPERMERCADO")
    private Supermercado supermercado;

    @Column(name = "orden")
    private Long orden;

    @Column(name = "precio")
    private Double precio;

    private ProductoSupermercado(){}
}
