package com.ffm.utilerias.ot.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ResponseSalesForce {

	    public String id;
	    public String typeObject;
	    public List<FieldsToUpdate> fieldsToUpdate;
	
}
