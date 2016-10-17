package com.algaworks.curso.jpa2.controller;

import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.modelo.Sexo;
import com.algaworks.curso.jpa2.service.CadastroMotoristaService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@ViewScoped
public class CadastroMotoristaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Motorista motorista;

    private List<Sexo> sexos;

    @Inject
    private CadastroMotoristaService cadastroMotoristaService;

    @PostConstruct
    public void inicializar() {
        this.limpar();
        this.sexos = Arrays.asList(Sexo.values());
    }

    public void salvar() {
        try {
            this.cadastroMotoristaService.salvar(motorista);
            FacesUtil.addSuccessMessage("Motorista salvo com sucesso!");
        } catch (NegocioException e) {
            FacesUtil.addErrorMessage(e.getMessage());
        }

        this.limpar();
    }

    public void limpar() {
        this.motorista = new Motorista();
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public List<Sexo> getSexos() {
        return sexos;
    }
}
