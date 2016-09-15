package com.algaworks.curso.jpa2.service;

import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

import javax.inject.Inject;
import java.io.Serializable;

public class CadastroModeloCarroService implements Serializable {

    @Inject
    ModeloCarroDAO modeloCarroDAO;

    @Transactional
    public void salvar(ModeloCarro modeloCarro) throws NegocioException {
        if (modeloCarro.getDescricao() == null || modeloCarro.getDescricao().trim().equals("")) {
            throw new NegocioException("O nome do modelo é obrigatório.");
        }

        if (modeloCarro.getFabricante() == null) {
            throw new NegocioException("O fabricante e obrigatório");
        }

        this.modeloCarroDAO.salvar(modeloCarro);
    }


}
