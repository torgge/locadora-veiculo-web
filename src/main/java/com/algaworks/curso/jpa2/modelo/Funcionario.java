package com.algaworks.curso.jpa2.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by george.bonespirito on 12/10/2016.
 */
@Entity
@DiscriminatorValue("2")
public class Funcionario extends Pessoa {

    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
