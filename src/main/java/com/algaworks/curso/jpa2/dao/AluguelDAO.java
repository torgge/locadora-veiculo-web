package com.algaworks.curso.jpa2.dao;

import com.algaworks.curso.jpa2.modelo.Aluguel;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

public class AluguelDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public void salvar(Aluguel aluguel) {
        manager.merge(aluguel);
    }
}
