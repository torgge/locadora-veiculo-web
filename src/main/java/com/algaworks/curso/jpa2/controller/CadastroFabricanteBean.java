package com.algaworks.curso.jpa2.controller;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.CadastroFabricanteService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by George on 08/08/2016.
 */

@Named
@ViewScoped
public class CadastroFabricanteBean implements Serializable {

    @Inject
    private CadastroFabricanteService cadastroFabricanteService;

    private Fabricante fabricante;

    public void salvar(){
        try {
            this.cadastroFabricanteService.salvar(fabricante);
            FacesUtil.addSuccessMessage("Fabricante salvo com sucesso!");
        } catch (NegocioException e) {
            FacesUtil.addErrorMessage(e.getMessage());
        }
    }

    @PostConstruct
    public void init(){
        this.limpar();
    }

    private void limpar() {
        this.fabricante = new Fabricante();
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}