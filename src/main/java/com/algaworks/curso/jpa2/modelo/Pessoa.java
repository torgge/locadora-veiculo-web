package com.algaworks.curso.jpa2.modelo;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by george.bonespirito on 11/10/2016.
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO_PESSOA", discriminatorType = DiscriminatorType.INTEGER)
@SequenceGenerator(name = "SEQ_PESSOA", sequenceName = "SEQ_PESSOA", initialValue = 1)
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PESSOA")
    private Long codigo;
    private String nome;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    private String cpf;

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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(getCodigo(), pessoa.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }
}
