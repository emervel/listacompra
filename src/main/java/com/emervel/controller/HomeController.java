package com.emervel.controller;

import com.emervel.dominio.ListaProductos;
import com.emervel.dominio.Producto;
import com.emervel.service.ProductoServicio;
import com.emervel.service.autenticacion.UserDetailsImpl;
import com.emervel.service.autenticacion.UsuarioServicio;
import com.emervel.service.autenticacion.UsuarioServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;



@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private ProductoServicio productoServicio;

	@Autowired
	public HomeController (ProductoServicio productoServicio) {
		this.productoServicio = productoServicio;
	}

	@RequestMapping("/")
	public String home(Model model){
		logger.info("inicio");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName();
		logger.info(login);
		List<Producto> productos = productoServicio.productosUsuario(login);
		List<ListaProductos>  listaProductos = productoServicio.productosEnListaUsuario(login,productos);
		Collections.sort(listaProductos, new Comparator<ListaProductos>(){
			public int compare(ListaProductos s1, ListaProductos s2) {
				return s1.getProducto().getNombre().compareToIgnoreCase(s2.getProducto().getNombre());
			}
		});
		model.addAttribute("listaProductos", listaProductos);
		model.addAttribute("productos", productos);
		return "index";
	}

}
