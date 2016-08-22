package com.algaworks.curso.jpa2.service;

import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

import javax.inject.Inject;

/**
 * Created by George on 22/08/2016.
 */
public class CadastroModeloCarroService {

    @Inject
    private ModeloCarroDAO modeloCarroDAO;

    @Transactional
    public void salvar(ModeloCarro modeloCarro) throws NegocioException{
        if (modeloCarro.getDescricao() == null || modeloCarro.getDescricao().trim().equals("")){
            throw new NegocioException("O nome do fabricante é obrigatório.");
        }

        if (modeloCarro.getFabricante() == null){
            throw new NegocioException("O fabricante é obrigatório.");
        }

        this.modeloCarroDAO.salvar(modeloCarro);
    }
}
