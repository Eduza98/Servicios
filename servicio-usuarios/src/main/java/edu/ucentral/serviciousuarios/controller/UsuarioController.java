package edu.ucentral.serviciousuarios.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import edu.ucentral.commonsservicio.controller.CommonController;
import edu.ucentral.commonusuario.model.Usuario;
import edu.ucentral.serviciousuarios.service.UsuarioService;

@RestController
public class UsuarioController extends CommonController<Usuario, UsuarioService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long id){
		if(result.hasErrors()) {
			return validar(result);
		}

		Optional<Usuario> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Usuario usuarioBd = optional.get();
		usuarioBd.setApellido(usuario.getApellido());
		usuarioBd.setNombre(usuario.getNombre());
		usuarioBd.setEmail(usuario.getEmail());
		usuarioBd.setEnabled(usuario.getEnabled());
		usuarioBd.setPassword(usuario.getPassword());
		usuarioBd.setUsername(usuario.getUsername());
		usuarioBd.setRoles(usuario.getRoles());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioBd));
	}
	
	@GetMapping("/buscar-username")
	public ResponseEntity<?> buscarPorUsername(@RequestParam("username") String username){
		Usuario usuario = service.findByUsername(username);
		if(usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
}
