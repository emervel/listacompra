package com.emervel.controller;

import com.emervel.dominio.Producto;
import com.emervel.dominio.Supermercado;
import com.emervel.dominio.Usuario;
import com.emervel.service.ProductoServicio;
import com.emervel.service.SupermercadoServicio;
import com.emervel.service.autenticacion.UsuarioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by guopm on 18/06/2017.
 */
@Controller
public class ConfigurarController {

    private static final Logger logger = LoggerFactory.getLogger(ConfigurarController.class);

    private ProductoServicio productoServicio;

    private SupermercadoServicio supermercadoServicio;

    private UsuarioServicio usuarioServicio;
    @Autowired
    public ConfigurarController(ProductoServicio productoServicio, SupermercadoServicio supermercadoServicio, UsuarioServicio usuarioServicio) {
        this.productoServicio = productoServicio;
        this.supermercadoServicio = supermercadoServicio;
        this.usuarioServicio = usuarioServicio;
    }

    @RequestMapping("/configurar/productos")
    public String listProductos(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();
        logger.info(login);
        List<Producto> productos = productoServicio.productosUsuario(login);
        Collections.sort(productos, new Comparator<Producto>(){
            public int compare(Producto s1, Producto s2) {
                return s1.getNombre().compareToIgnoreCase(s2.getNombre());
            }
        });
        model.addAttribute("productos", productos);
        return "admin/post/list";
    }

    @RequestMapping("/configurar/supermercados")
    public String listSupermercados(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();
        logger.info(login);
        List<Supermercado> supermercados = supermercadoServicio.list(login);
        model.addAttribute("supermercados", supermercados);
        return "configurar/supermercadoList";
    }

    @RequestMapping("/configurar/crearSupermercado")
    public String crearSupermercados(Model model) {
        model.addAttribute("supermercado", new Supermercado());
        return "configurar/supermercadoForm";
    }

    @RequestMapping(value = "/configurar/crearSupermercado/save", method = RequestMethod.POST)
    public String guardarSupermercado(@Valid Supermercado supermercado, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "configurar/supermercadoForm";
        } else {
            Date fechaHoy = new Date();
            supermercado.setUltimaModificacion(fechaHoy);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String login = auth.getName();
            Usuario usuario = usuarioServicio.findByLogin(login);
            Set<Usuario> usuarios = new HashSet<Usuario>();
            usuarios.add(usuario);
            supermercado.setUsuarios(usuarios);
            Supermercado guardarSuper = supermercadoServicio.save(supermercado);
            return "redirect:/configurar/supermercados";
        }
    }
/*
    @RequestMapping("/admin/post/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.get(id));
        return "admin/post/view";
    }

    @RequestMapping("/admin/post/create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("authors", authorService.list());
        return "admin/post/postForm";
    }

    @RequestMapping(value = "/admin/post/save", method = RequestMethod.POST)
    public String save(@Valid Post post, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("authors", authorService.list());
            return "/admin/post/postForm";
        } else {
            Post postSaved = postService.save(post);
            return "redirect:/admin/post/" + postSaved.getId();
        }
    }

    @RequestMapping("/admin/post/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.get(id));
        model.addAttribute("authors", authorService.list());
        return "/admin/post/postForm";
    }

    @RequestMapping("/admin/post/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        postService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Post was deleted");
        return "redirect:/admin/posts";
    }*/
}