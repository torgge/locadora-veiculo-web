package com.algaworks.curso.jpa2.modelo;

import javax.persistence.*;

/**
 * Created by George on 08/08/2016.
 */
@Entity
@SequenceGenerator(name = "SEQ_FABRICANTE", sequenceName = "SEQ_FABRICANTE", initialValue = 1)
public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_FABRICANTE")
    private Long codigo;
    private String nome;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fabricante)) return false;

        Fabricante that = (Fabricante) o;

        return getCodigo().equals(that.getCodigo());

    }

    @Override
    public int hashCode() {
        return getCodigo().hashCode();
    }
}
