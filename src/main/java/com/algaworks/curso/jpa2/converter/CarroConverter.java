package com.algaworks.curso.jpa2.converter;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Carro.class)
public class CarroConverter implements Converter {

    private CarroDAO motoristaDAO;

    public CarroConverter() {
        this.motoristaDAO = CDIServiceLocator.getBean(CarroDAO.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Carro retorno = null;

        if (value != null) {
            retorno = this.motoristaDAO.buscarPeloCodigo(new Long(value));
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long codigo = ((Carro) value).getCodigo();
            String retorno = (codigo == null ? null : codigo.toString());

            return retorno;
        }

        return "";
    }

}