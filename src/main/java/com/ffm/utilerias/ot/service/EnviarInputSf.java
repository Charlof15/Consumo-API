package com.ffm.utilerias.ot.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.beans.factory.annotation.Autowired;

import com.ffm.utilerias.ot.component.Configuraciones;
import com.ffm.utilerias.ot.component.Variables;
import com.ffm.utilerias.ot.mapper.ConfirmacionMapper;
import com.ffm.utilerias.ot.model.input.InputConfirmacion;
import com.ffm.utilerias.ot.model.ws.upsf.FieldsToUpdate;
import com.ffm.utilerias.ot.model.ws.upsf.InputUpSF;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EnviarInputSf extends ConfirmacionService{
	
	public static final String TYPE_OBJECT_SF = "OrdenServicio__c";
	public static final String FILE_NAME_SF = "Confirmada__c";
	
	@Autowired
	ConfirmacionService service;
	
	public List<InputUpSF> InputSf(String idFolio, Integer esConfirmada) {
		FieldsToUpdate fieldsToUpdate = new FieldsToUpdate();
		InputUpSF inputUpSF = new InputUpSF();
		List<InputUpSF> list = new ArrayList<>();
		List<FieldsToUpdate> list2 = new ArrayList<>();
		String objectSf = service.configuraciones().get("TYPE_OBJECT_SF").getValor();
		String fileName = service.configuraciones().get("FILE_NAME_SF").getValor();
		inputUpSF.setId(idFolio);
		inputUpSF.setTypeObject(TYPE_OBJECT_SF);
		fieldsToUpdate.setFieldName(FILE_NAME_SF);
		boolean newValue = (esConfirmada <=0);
		String decisionNewValue = (newValue) ? "false" :"true";
		fieldsToUpdate.setNewValue(decisionNewValue);
		list2.add(fieldsToUpdate);
		inputUpSF.setFieldsToUpdate(list2);
		list.add(inputUpSF);
		return list;
		
	}
}
