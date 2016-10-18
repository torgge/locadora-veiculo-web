package com.algaworks.curso.jpa2.service;

import com.algaworks.curso.jpa2.dao.MotoristaDAO;
import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

import javax.inject.Inject;
import java.io.Serializable;

public class CadastroMotoristaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private MotoristaDAO motoristaDAO;

    @Transactional
    public void salvar(Motorista motorista) throws NegocioException {
        if (motorista.getNumeroCNH() == null || motorista.getNumeroCNH().trim().equals("")) {
            throw new NegocioException("O número da CNH é exigido para o motorista.");
        }
        this.motoristaDAO.salvar(motorista);
    }
}
