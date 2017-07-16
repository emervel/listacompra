package com.emervel.dominio;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by guopm on 21/06/2017.
 */
@EqualsAndHashCode(exclude="usuarios")
@ToString(exclude = "usuarios")
@Data
@Entity
@Table(name = "Rol")
public class Rol implements Serializable{
    @Id @GeneratedValue @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany( mappedBy = "roles")
    private Set<Usuario> usuarios = new HashSet<Usuario>();

    private Rol(){}
/*
    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "idRol=" + idRol +
                ", nombre='" + nombre +
                '}';
    }*/
}
