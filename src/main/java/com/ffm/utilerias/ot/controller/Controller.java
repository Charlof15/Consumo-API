package com.ffm.utilerias.ot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ffm.utilerias.ot.model.Respuesta;
import com.ffm.utilerias.ot.service.Services;

import lombok.Getter;

@RestController
public class Controller {

	
	
	@Autowired
	private Services services;
	
	@GetMapping(path = "/resultado/idOt/{idOt}")
	public ResponseEntity<Respuesta> confirmarOrden(@PathVariable(value = "idOt") String idOt){
		return services.obtenerApiRest(idOt);
	}
	
}
