package com.ffm.utilerias.ot.mapper;
	
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import com.ffm.utilerias.ot.component.Configuraciones;
import com.ffm.utilerias.ot.model.output.OutputFolioOTs;

import feign.Param;

@Mapper
public interface ConfirmacionMapper{
	
	@MapKey("llave")
	public Map<String,Configuraciones> consultaConfiguracion(@Param(value = "idPropietario") Integer idPropietario,@Param(value = "idUnidadNegocio") Integer idUnidadNegocio);
	
	public OutputFolioOTs obtenerIdFolio(int IdOrden);
	
	public void updateOTConfirmada(int idOrden,Integer esConfirmada);
	
}