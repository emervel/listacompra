package com.emervel.service;

import com.emervel.dominio.Supermercado;
import com.emervel.repository.SupermercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guopm on 01/07/2017.
 */
@Service
public class SupermercadoServicio {
    private SupermercadoRepository supermercadoRepository;

    @Autowired
    public SupermercadoServicio(SupermercadoRepository supermercadoRepository){
        this.supermercadoRepository = supermercadoRepository;
    }

    public List<Supermercado> list(String login) {
        return supermercadoRepository.findAllByUsuariosLoginOrderByMarca(login);
//        return supermercadoRepository.findAllOrderByMarcaAndNombre();
    }

    public Supermercado save(Supermercado supermercado) {
        return supermercadoRepository.save(supermercado);
    }

}
