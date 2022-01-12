package com.ffm.utilerias.ot.model.ws.upsf;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputUpSF {
    private String id;
    private String typeObject;
    private List<FieldsToUpdate> fieldsToUpdate;
}
