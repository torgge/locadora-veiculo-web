package com.algaworks.curso.jpa2.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by torgg on 26/09/2016.
 */
@Entity
@SequenceGenerator(name = "SEQ_ALUGUEL", sequenceName = "SEQ_ALUGUEL", initialValue = 1)
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ALUGUEL")
    private Long codigo;
    private BigDecimal valorTotal;
    @ManyToOne
    @JoinColumn(name = "codigo_carro")
    private Carro carro;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo_apolice_seguro")
    private ApoliceSeguro apoliceSeguro;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public ApoliceSeguro getApoliceSeguro() {
        return apoliceSeguro;
    }

    public void setApoliceSeguro(ApoliceSeguro apoliceSeguro) {
        this.apoliceSeguro = apoliceSeguro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluguel)) return false;
        Aluguel aluguel = (Aluguel) o;
        return Objects.equals(getCodigo(), aluguel.getCodigo()) &&
                Objects.equals(getValorTotal(), aluguel.getValorTotal()) &&
                Objects.equals(getCarro(), aluguel.getCarro()) &&
                Objects.equals(getApoliceSeguro(), aluguel.getApoliceSeguro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo(), getValorTotal(), getCarro(), getApoliceSeguro());
    }
}
