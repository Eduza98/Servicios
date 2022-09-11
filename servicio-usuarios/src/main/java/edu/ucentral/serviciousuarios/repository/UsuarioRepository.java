package edu.ucentral.serviciousuarios.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.ucentral.commonusuario.model.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
	public Usuario findByUsername(String username);
}
