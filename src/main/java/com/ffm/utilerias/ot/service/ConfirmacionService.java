package com.ffm.utilerias.ot.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffm.utilerias.ot.component.Configuraciones;
import com.ffm.utilerias.ot.component.Variables;
import com.ffm.utilerias.ot.mapper.ConfirmacionMapper;
import com.ffm.utilerias.ot.model.output.OutputCormirmacion;
import com.ffm.utilerias.ot.model.output.OutputFolioOTs;
import com.ffm.utilerias.ot.utility.LlamadaApiIntegracionSf;



@Service
public class  ConfirmacionService{
	
	@Autowired
	private Variables var;
	
	@Autowired
	private ConfirmacionMapper confirmacionMapper;
	
	@Autowired
	private LlamadaApiIntegracionSf requestApi;
	
	public  Map<String, Configuraciones> configuraciones(){
		Map<String, Configuraciones> configuraciones = confirmacionMapper.consultaConfiguracion(
			var.getDetalleJWT().getIdPropietario(), var.getDetalleJWT().getIdUnidadNegocio());
		return configuraciones;
	}
	
	public Object actualizarConfirmacion(int idOrden,Integer esConfirmada,String idFolio) {
		OutputCormirmacion outputCormirmacion = new OutputCormirmacion();
		OutputFolioOTs outputFolioOTs = confirmacionMapper.obtenerIdFolio(idOrden);
		new Thread(() -> requestApi.requestApi(outputFolioOTs.getIdFolio(), esConfirmada)).start();
		confirmacionMapper.updateOTConfirmada(idOrden, esConfirmada);
		return outputCormirmacion;
	}
}
	
	
	

