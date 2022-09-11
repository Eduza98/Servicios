package edu.ucentral.servicio.estudiantes.service;

import java.util.List;

import edu.ucentral.commonnestudiantes.model.Estudiante;
import edu.ucentral.commonsservicio.service.CommonService;

public interface EstudianteService extends CommonService<Estudiante> {
	
	public List<Estudiante> findByNombreOrApellido(String termino);

}
