package com.algaworks.curso.jpa2.controller;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.CadastroModeloCarroService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by George on 22/08/2016.
 */
@Named
@ViewScoped
public class CadastroModeloCarroBean implements Serializable {

    private static final Long serialVersionUID = 1L;

    private ModeloCarro modeloCarro;

    private List<Fabricante> fabricantes;

    @Inject
    private CadastroModeloCarroService cadastroModeloCarroService;

    @Inject
    private FabricanteDAO fabricanteDAO;

    public void salvar(){
        try {
            this.cadastroModeloCarroService.salvar(modeloCarro);
            FacesUtil.addSuccessMessage("Modelo carro salvo com sucesso!");
        } catch (NegocioException e) {
            FacesUtil.addErrorMessage(e.getMessage());
        }

        this.limpar();
    }

    @PostConstruct
    public void Inicializar(){
        this.limpar();
        this.fabricantes = fabricanteDAO.buscarTodos();
    }

    public void limpar() {
        this.modeloCarro = new ModeloCarro();
    }

    public ModeloCarro getModeloCarro() {
        return modeloCarro;
    }
    public void setModeloCarro(ModeloCarro modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public List<Fabricante> getFabricantes() {
        return fabricantes;
    }


}
