package com.emervel.dominio;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by guopm on 21/06/2017.
 */
@Entity
@Data
@Table( name = "usuario_producto" )
public class UsuarioProducto implements Serializable {
    @Id
    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn(name = "ID_PRODUCTO")
    private Producto producto;

    @Id
    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn(name = "LOGIN")
    private Usuario usuario;

    @Column(name = "ULTIMA_MODIFICACION")
    private Date ultimaModificacion;

    @Column(name = "CANTIDAD")
    private Integer cantidad;
    private UsuarioProducto(){}
}
