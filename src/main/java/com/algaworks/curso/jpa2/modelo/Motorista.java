package com.algaworks.curso.jpa2.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by george.bonespirito on 11/10/2016.
 */

@Entity
@DiscriminatorValue("1")
public class Motorista extends Pessoa {

    private String numeroCNH;

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

}
