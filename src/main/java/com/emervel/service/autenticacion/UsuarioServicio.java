package com.emervel.service.autenticacion;

import com.emervel.dominio.Usuario;

public interface UsuarioServicio {

	public Usuario findByLogin(String login);
	
}
