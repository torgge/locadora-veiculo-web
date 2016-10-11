package com.algaworks.curso.jpa2.controller;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.modelo.Carro;
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
public class PesquisaCarroBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    CarroDAO motoristaDAO;

    private List<Carro> carros = new ArrayList<>();

    private Carro carroSelecionado;

    public List<Carro> getCarros() {
        return carros;
    }

    public void excluir() {
        try {
            motoristaDAO.excluir(carroSelecionado);
            this.carros.remove(carroSelecionado);
            FacesUtil.addSuccessMessage("Carro placa " + carroSelecionado.getPlaca() + " excluído com sucesso.");
        } catch (NegocioException e) {
            FacesUtil.addErrorMessage(e.getMessage());
        }
    }

    public Carro getCarroSelecionado() {
        return carroSelecionado;
    }

    public void setCarroSelecionado(Carro carroSelecionado) {
        this.carroSelecionado = carroSelecionado;
    }

    public void buscarCarroComAcessorios() {
        carroSelecionado = motoristaDAO.buscarCarroComACessorios(this.carroSelecionado.getCodigo());
    }


    @PostConstruct
    public void inicializar() {
        carros = motoristaDAO.buscarTodos();
    }

}
