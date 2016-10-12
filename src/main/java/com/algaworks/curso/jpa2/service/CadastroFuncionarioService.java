package com.algaworks.curso.jpa2.service;

import com.algaworks.curso.jpa2.dao.FuncionarioDAO;
import com.algaworks.curso.jpa2.modelo.Funcionario;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by george.bonespirito on 12/10/2016.
 */
public class CadastroFuncionarioService implements Serializable {


    private static final long serialVersionUID = 1L;

    @Inject
    private FuncionarioDAO funcionarioDAO;

    @Transactional
    public void salvar(Funcionario funcionario) throws NegocioException {
        if (funcionario.getMatricula() == null || funcionario.getMatricula().trim().equals("")) {
            throw new NegocioException("O número da Matrícula é exigido para o funcionário.");
        }
        this.funcionarioDAO.salvar(funcionario);
    }
}
