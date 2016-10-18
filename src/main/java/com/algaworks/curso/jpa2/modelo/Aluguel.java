package com.algaworks.curso.jpa2.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

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
    @Temporal(TemporalType.DATE)
    private Calendar dataPedido;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDevolucao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEntrega;
    @ManyToOne
    @JoinColumn(name = "codigo_motorista")
    private Motorista motorista;

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

    public Calendar getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Calendar dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluguel)) return false;
        Aluguel aluguel = (Aluguel) o;
        return Objects.equals(getCodigo(), aluguel.getCodigo()) &&
                Objects.equals(getCarro(), aluguel.getCarro()) &&
                Objects.equals(getApoliceSeguro(), aluguel.getApoliceSeguro()) &&
                Objects.equals(getMotorista(), aluguel.getMotorista());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo(), getCarro(), getApoliceSeguro(), getMotorista());
    }
}
