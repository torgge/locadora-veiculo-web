package com.algaworks.curso.jpa2.modelo;

import javax.persistence.*;

/**
 * Created by George on 22/08/2016.
 */
@Entity
@SequenceGenerator(name = "SEQ_MODELOCARRO", sequenceName = "SEQ_MODELOCARRO", initialValue = 1)
public class ModeloCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MODELOCARRO")
    private Long codigo;
    private String descricao;
    @ManyToOne
    private Fabricante fabricante;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
