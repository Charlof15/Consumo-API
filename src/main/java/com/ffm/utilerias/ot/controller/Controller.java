package com.ffm.utilerias.ot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ffm.utilerias.ot.model.input.InputConfirmacion;
import com.ffm.utilerias.ot.model.output.OutputFolioOTs;
import com.ffm.utilerias.ot.service.ConfirmacionService;

@RestController
public class Controller {

	
	@Autowired
	private ConfirmacionService confirmacionService;
	
	
		
	@PatchMapping(path = "/confirmacion/idOrden/{idOrden}")
	public Object actualizaConfirmacion(@PathVariable(value = "idOrden") int idOrden,@RequestBody InputConfirmacion inputConfirmacion, OutputFolioOTs outputFolioOTs) {
			return confirmacionService.actualizarConfirmacion(idOrden, inputConfirmacion.getEsConfirmada(),outputFolioOTs.getIdFolio());
							
	}

}