package edu.ucentral.serviciousuarios.service;

import edu.ucentral.commonsservicio.service.CommonService;
import edu.ucentral.commonusuario.model.Usuario;

public interface UsuarioService extends CommonService<Usuario> {
	public Usuario findByUsername(String username);
}
