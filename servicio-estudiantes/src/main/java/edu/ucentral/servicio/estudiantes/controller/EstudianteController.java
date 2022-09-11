package edu.ucentral.servicio.estudiantes.controller;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.ucentral.commonnestudiantes.model.Estudiante;
import edu.ucentral.commonsservicio.controller.CommonController;
import edu.ucentral.servicio.estudiantes.service.EstudianteService;

@RestController
public class EstudianteController extends CommonController<Estudiante,EstudianteService>{

	
	@PutMapping("/{id}")
	public ResponseEntity<?> modificar(@RequestBody Estudiante estudiante, @PathVariable Long id, BindingResult result){
		if(result.hasErrors()) {
			return validar(result);
		}

		Optional<Estudiante> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Estudiante est = optional.get();
		est.setApellido(estudiante.getApellido());
		est.setCodigo(estudiante.getCodigo());
		est.setEmail(estudiante.getEmail());
		est.setNombre(estudiante.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(est));
	}
	
	@GetMapping("/filtrar/{termino}")
	public ResponseEntity<?> consultarPorNombreOrApellido(@PathVariable String termino){
		return ResponseEntity.ok(service.findByNombreOrApellido(termino));
	}
	
	@PostMapping("/crear-con-imagen")
	public ResponseEntity<?> crearConImagen(@Valid Estudiante estudiante, BindingResult result,@RequestParam MultipartFile archivo) throws IOException{
		if(!archivo.isEmpty()) {
			estudiante.setImagen(archivo.getBytes());
		}
		return super.crear(estudiante, result);
	}
	
	@PutMapping("/editar-con-imagen/{id}")
	public ResponseEntity<?> modificarConImagen(@Valid Estudiante estudiante, BindingResult result, @PathVariable Long id, @RequestParam MultipartFile archivo) throws IOException{
		if(result.hasErrors()) {
			return validar(result);
		}

		Optional<Estudiante> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Estudiante est = optional.get();
		est.setApellido(estudiante.getApellido());
		est.setCodigo(estudiante.getCodigo());
		est.setEmail(estudiante.getEmail());
		est.setNombre(estudiante.getNombre());
		if(!archivo.isEmpty()) {
			est.setImagen(archivo.getBytes());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(est));
	}

	@GetMapping("/upload/img/{id}")
	public ResponseEntity<?> verImagen(@PathVariable Long id){
		Optional<Estudiante> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Resource imagen = new ByteArrayResource(optional.get().getImagen());
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagen);
	}
}
