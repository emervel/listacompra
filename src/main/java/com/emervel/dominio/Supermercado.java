package com.emervel.dominio;


import com.emervel.json.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(exclude="usuarios")
@Entity
@Table( name = "supermercado" )
public class Supermercado {
    @Id
    @GeneratedValue
    @Column(name = "ID_SUPERMERCADO")
    private Long idSupermercado;

    @Column( nullable=false )
    private String nombre;

    @Column( nullable=false )
    private String marca;

    @Column(columnDefinition = "TEXT")
    private String direccion;

    private Boolean activo;

    @CreatedDate
    @Column(columnDefinition = "TIMESTAMP")
    @JsonSerialize(using=JsonDateSerializer.class)
    private Date ultimaModificacion;

    @OneToMany( mappedBy = "supermercado")
    private List<ProductoSupermercado> productoSupermercados;

    @ManyToMany( mappedBy = "supermercados")
    private Set<Usuario> usuarios = new HashSet<Usuario>();

    @Enumerated(EnumType.STRING)
    private MarcaSupermercado marcaSupermercado;

    public Supermercado(){}

    public static enum MarcaSupermercado {
        Mercadona,Dia,Carrefour
    }
}
