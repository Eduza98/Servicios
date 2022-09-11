package edu.ucentral.servicio.estudiantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EntityScan({"edu.ucentral.commonnestudiantes.model"})
@EnableEurekaClient
@SpringBootApplication
public class ServicioEstudiantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioEstudiantesApplication.class, args);
	}

}
