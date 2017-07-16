package com.emervel.dominio;

import lombok.Data;
import org.hibernate.annotations.Proxy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by guopm on 21/06/2017.
 */
@Data
@Entity
@Table( name = "producto" )
public class Producto {
    @Id @GeneratedValue @Column(name = "ID_PRODUCTO")
    private Long idProducto;

    @Column( nullable=false )
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private String imagen;

    private Boolean activo;

    @CreatedDate
    @Column(columnDefinition = "TIMESTAMP")
    private Date ultimaModificacion;

    @OneToMany( mappedBy = "producto", fetch = FetchType.EAGER )
    private List<ProductoSupermercado> productoSupermercados;

    private Producto(){}
}
