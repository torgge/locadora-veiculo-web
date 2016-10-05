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
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModeloCarro)) return false;

        ModeloCarro that = (ModeloCarro) o;

        return getCodigo().equals(that.getCodigo());

    }

    @Override
    public int hashCode() {
        return getCodigo().hashCode();
    }
}
