package com.algaworks.curso.jpa2.controller;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    FabricanteDAO fabricanteDAO;

    private List<Fabricante> fabricantes = new ArrayList<>();

    private Fabricante fabricanteSelecionado;

    public List<Fabricante> getFabricantes() {
        return fabricantes;
    }

    public void excluir() {
        try {
            fabricanteDAO.excluir(fabricanteSelecionado);
            this.fabricantes.remove(fabricanteSelecionado);
            FacesUtil.addSuccessMessage("Fabricante " + fabricanteSelecionado.getNome() + " excluído com sucesso.");
        } catch (NegocioException e) {
            FacesUtil.addErrorMessage(e.getMessage());
        }
        this.inicializar();
    }

    public Fabricante getFabricanteSelecionado() {
        return fabricanteSelecionado;
    }

    public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
        this.fabricanteSelecionado = fabricanteSelecionado;
        this.inicializar();
    }

    @PostConstruct
    public void inicializar() {
        fabricantes = fabricanteDAO.buscarTodos();
    }
}
