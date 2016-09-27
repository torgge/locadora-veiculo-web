package com.algaworks.curso.jpa2.modelo;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by torgg on 26/09/2016.
 */
@Entity
@Table(name = "apolice_seguro")
@SequenceGenerator(name = "SEQ_APOLICE_SEGURO", sequenceName = "SEQ_APOLICE_SEGURO", initialValue = 1)
public class ApoliceSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_APOLICE_SEGURO")
    private Long codigo;
    private BigDecimal valorFranquia;
    private Boolean protecaoTerceiro;
    private Boolean protecaoCausasNaturais;
    private Boolean protecaoRoubo;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValorFranquia() {
        return valorFranquia;
    }

    public void setValorFranquia(BigDecimal valorFranquia) {
        this.valorFranquia = valorFranquia;
    }

    public Boolean getProtecaoTerceiro() {
        return protecaoTerceiro;
    }

    public void setProtecaoTerceiro(Boolean protecaoTerceiro) {
        this.protecaoTerceiro = protecaoTerceiro;
    }

    public Boolean getProtecaoCausasNaturais() {
        return protecaoCausasNaturais;
    }

    public void setProtecaoCausasNaturais(Boolean protecaoCausasNaturais) {
        this.protecaoCausasNaturais = protecaoCausasNaturais;
    }

    public Boolean getProtecaoRoubo() {
        return protecaoRoubo;
    }

    public void setProtecaoRoubo(Boolean protecaoRoubo) {
        this.protecaoRoubo = protecaoRoubo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApoliceSeguro)) return false;

        ApoliceSeguro that = (ApoliceSeguro) o;

        if (!getCodigo().equals(that.getCodigo())) return false;
        if (getValorFranquia() != null ? !getValorFranquia().equals(that.getValorFranquia()) : that.getValorFranquia() != null)
            return false;
        if (getProtecaoTerceiro() != null ? !getProtecaoTerceiro().equals(that.getProtecaoTerceiro()) : that.getProtecaoTerceiro() != null)
            return false;
        if (getProtecaoCausasNaturais() != null ? !getProtecaoCausasNaturais().equals(that.getProtecaoCausasNaturais()) : that.getProtecaoCausasNaturais() != null)
            return false;
        return getProtecaoRoubo() != null ? getProtecaoRoubo().equals(that.getProtecaoRoubo()) : that.getProtecaoRoubo() == null;

    }

    @Override
    public int hashCode() {
        int result = getCodigo().hashCode();
        result = 31 * result + (getValorFranquia() != null ? getValorFranquia().hashCode() : 0);
        result = 31 * result + (getProtecaoTerceiro() != null ? getProtecaoTerceiro().hashCode() : 0);
        result = 31 * result + (getProtecaoCausasNaturais() != null ? getProtecaoCausasNaturais().hashCode() : 0);
        result = 31 * result + (getProtecaoRoubo() != null ? getProtecaoRoubo().hashCode() : 0);
        return result;
    }
}
