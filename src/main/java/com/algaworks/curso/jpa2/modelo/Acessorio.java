package com.algaworks.curso.jpa2.modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@SequenceGenerator(name = "SEQ_ACESSORIO", sequenceName = "SEQ_ACESSORIO", initialValue = 1)
public class Acessorio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ACESSORIO")
	private Long codigo;
	private String descricao;

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

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Acessorio)) return false;
        Acessorio acessorio = (Acessorio) o;
        return Objects.equals(getCodigo(), acessorio.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }
}
