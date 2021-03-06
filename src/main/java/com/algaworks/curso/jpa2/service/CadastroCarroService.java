package com.algaworks.curso.jpa2.service;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

import javax.inject.Inject;
import java.io.Serializable;

public class CadastroCarroService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CarroDAO motoristaDAO;

    @Transactional
    public void salvar(Carro carro) throws NegocioException {
        if (carro.getPlaca() == null || carro.getPlaca().trim().equals("")) {
            throw new NegocioException("A placa é obrigatória");
        }
        this.motoristaDAO.salvar(carro);
    }
}
