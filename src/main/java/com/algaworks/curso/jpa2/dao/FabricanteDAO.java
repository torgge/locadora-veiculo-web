package com.algaworks.curso.jpa2.dao;

import com.algaworks.curso.jpa2.modelo.Fabricante;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by George on 08/08/2016.
 */
public class FabricanteDAO implements Serializable {

    @Inject
    private EntityManager em;

    public void salvar(Fabricante fabricante){
        em.getTransaction().begin();
        em.persist(fabricante);
        em.getTransaction().commit();
    }
}
