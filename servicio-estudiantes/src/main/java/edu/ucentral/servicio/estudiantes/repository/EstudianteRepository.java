package edu.ucentral.servicio.estudiantes.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.ucentral.commonnestudiantes.model.Estudiante;

public interface EstudianteRepository extends PagingAndSortingRepository<Estudiante, Long> {
	@Query("SELECT e FROM Estudiante e WHERE e.nombre LIKE %?1% OR e.apellido LIKE %?1%")
	public List<Estudiante> findByNombreOrApellido(String termino);
}
