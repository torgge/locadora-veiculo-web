package com.algaworks.curso.jpa2.converter;

import com.algaworks.curso.jpa2.modelo.Carro;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

//@FacesConverter(value = "classeConverter")    
@FacesConverter(forClass = Carro.class)
public class ClasseConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Carro) {
            Carro entity = (Carro) value;
            if (entity != null && entity instanceof Carro && entity.getCodigo() != null) {
                uiComponent.getAttributes().put(entity.getCodigo().toString(), entity);
                return entity.getCodigo().toString();
            }
        }
        return "";
    }
}