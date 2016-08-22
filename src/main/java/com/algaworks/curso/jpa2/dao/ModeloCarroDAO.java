package com.algaworks.curso.jpa2.dao;

import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by George on 22/08/2016.
 */
public class ModeloCarroDAO {

    @Inject
    private EntityManager em;

    public void salvar(ModeloCarro modeloCarro){
        em.merge(modeloCarro);
    }

    @Transactional
    public void excluir(ModeloCarro modeloCarro) throws NegocioException {
        modeloCarro = em.find(ModeloCarro.class, modeloCarro.getCodigo());
        em.remove(modeloCarro);
        em.flush();
    }

    public List<ModeloCarro> buscarTodos() {
        return em.createQuery("from ModeloCarro").getResultList();
    }

    public ModeloCarro buscarPeloCodigo(Long codigo) {
        return em.find(ModeloCarro.class, codigo);
    }
}
