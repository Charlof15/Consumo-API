package com.ffm.utilerias.ot.model.output;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.ffm.utilerias.ot.utility.LlamadaApiIntegracionSf;
import com.netflix.discovery.converters.Auto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutputGeneral {
	
	private String mensaje = "Operacion exitosa";
	private String description = "Ejecucion correcta";
	private String version = "1.0";
	//private String instancia;
	
	
	
	
}
