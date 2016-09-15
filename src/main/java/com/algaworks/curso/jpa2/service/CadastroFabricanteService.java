package com.algaworks.curso.jpa2.service;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

import javax.inject.Inject;
import java.io.Serializable;

public class CadastroFabricanteService implements Serializable {

    @Inject
    private FabricanteDAO fabricanteDAO;

    @Transactional
    public void salvar(Fabricante fabricante) throws NegocioException {
        if (fabricante.getNome() == null || fabricante.getNome().trim().equals("")) {
            throw new NegocioException("O nome do fabricante é obrigatório");
        }

        this.fabricanteDAO.salvar(fabricante);
    }

}
