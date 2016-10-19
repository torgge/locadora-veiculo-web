package com.algaworks.curso.jpa2.controller;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.dao.MotoristaDAO;
import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.ApoliceSeguro;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.service.CadastroAluguelService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class NovoAluguelBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Aluguel aluguel;

    private List<Carro> carros;

    private List<Motorista> motoristas;

    @Inject
    private CadastroAluguelService cadastroAluguelService;

    @Inject
    private CarroDAO carroDAO;

    @Inject
    private MotoristaDAO motoristaDAO;

    public void salvar() {
        try {
            this.cadastroAluguelService.salvar(aluguel);
            FacesUtil.addSuccessMessage("Aluguel salvo com sucesso!");
        } catch (NegocioException e) {
            FacesUtil.addErrorMessage(e.getMessage());
        }

        this.limpar();
    }

    @PostConstruct
    public void inicializar() {
        this.limpar();

        this.carros = this.carroDAO.buscarTodos();
        this.motoristas = this.motoristaDAO.buscarTodos();
    }

    public void limpar() {
        this.aluguel = new Aluguel();
        this.aluguel.setApoliceSeguro(new ApoliceSeguro());
        this.aluguel.setCarro(new Carro());
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public List<Motorista> getMotoristas() {
        return motoristas;
    }

}
