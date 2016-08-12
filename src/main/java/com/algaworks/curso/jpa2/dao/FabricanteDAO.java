package com.algaworks.curso.jpa2.dao;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * Created by George on 08/08/2016.
 */
public class FabricanteDAO implements Serializable {

    @Inject
    private EntityManager em;

    public void salvar(Fabricante fabricante){
        em.persist(fabricante);
    }

    public void excluir(Fabricante fabricante) throws NegocioException {
        em.find(Fabricante.class, fabricante.getCodigo());
        em.remove(fabricante);
        em.flush();
    }

    public List<Fabricante> buscarTodos() {
        return em.createQuery("from Fabricante").getResultList();
    }
}
