package edu.ucentral.servicio.estudiantes.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ucentral.commonnestudiantes.model.Estudiante;
import edu.ucentral.commonsservicio.service.CommonServiceImpl;
import edu.ucentral.servicio.estudiantes.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl extends CommonServiceImpl<Estudiante, EstudianteRepository > implements EstudianteService {
		
	@Override
	@Transactional(readOnly = true)
	public List<Estudiante> findByNombreOrApellido(String termino){
		return repository.findByNombreOrApellido(termino);
	}

}
