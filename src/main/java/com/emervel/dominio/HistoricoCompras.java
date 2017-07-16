package com.emervel.dominio;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by guopm on 21/06/2017.
 */
@Entity
@Data
@Table(name = "historico_compras")
public class HistoricoCompras {
    @Id @GeneratedValue
    private Long id;

    @NotNull @OneToOne @JoinColumn(name = "login")
    private Usuario usuario;
    @NotNull @OneToOne @JoinColumn(name = "id_supermercado")
    private Supermercado supermercado;
    @NotNull
    private Date ultimaModificacion;
    @Column(columnDefinition = "TEXT")
    private String productos;
    private Double precio;

    private HistoricoCompras(){}
}
