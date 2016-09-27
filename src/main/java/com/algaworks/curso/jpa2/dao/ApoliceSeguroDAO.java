package com.algaworks.curso.jpa2.dao;

import com.algaworks.curso.jpa2.modelo.ApoliceSeguro;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * Created by torgg on 26/09/2016.
 */
public class ApoliceSeguroDAO implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public void salvar(ApoliceSeguro apoliceSeguro) {
        manager.merge(apoliceSeguro);
    }

    @SuppressWarnings("unchecked")
    public List<ApoliceSeguro> buscaTodos() {
        return manager.createQuery("from apolice_seguro").getResultList();
    }
}
