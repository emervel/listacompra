package com.emervel.dominio;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by guopm on 21/06/2017.
 */
//@EqualsAndHashCode(exclude="roles")
@EqualsAndHashCode(exclude = {"roles","supermercados"})
@ToString(exclude = "roles")
@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    @Id @NotNull
    private String login;
    @NotNull
    private String password;
    @NotNull
    private String nombre;
    private Boolean activo;
    private Date ultimaModificacion;
    @OneToMany( mappedBy = "usuario", fetch = FetchType.EAGER )
    private List<UsuarioProducto> usuarioProductos;

    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinTable(
            name = "usuario_rol",
            joinColumns = {@JoinColumn(name="login")},
            inverseJoinColumns = {@JoinColumn(name="id_rol")}
    )
    private Set<Rol> roles = new HashSet<Rol>();

    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinTable(
            name = "usuario_supermercado",
            joinColumns = {@JoinColumn(name="login")},
            inverseJoinColumns = {@JoinColumn(name="id_supermercado")}
    )
    private Set<Supermercado> supermercados = new HashSet<Supermercado>();

    private Usuario(){}


}
