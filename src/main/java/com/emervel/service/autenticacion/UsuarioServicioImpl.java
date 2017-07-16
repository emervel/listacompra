package com.emervel.service.autenticacion;

import com.emervel.dominio.Usuario;
import com.emervel.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio, UserDetailsService {

	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioServicioImpl(UsuarioRepository usuarioRepository){
		this.usuarioRepository = usuarioRepository;
	}

	@Transactional
	@Override
	public Usuario findByLogin(String login) {
		return usuarioRepository.findByLogin(login);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = null;
		try {
			usuario =  findByLogin(username);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getMessage());
		}
		if( usuario == null ){
			throw new UsernameNotFoundException(username);
		}
		
		return new UserDetailsImpl(usuario);
	}
	
}
