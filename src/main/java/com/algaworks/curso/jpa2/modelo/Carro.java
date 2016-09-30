package com.algaworks.curso.jpa2.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@SequenceGenerator(name = "SEQ_CARRO", sequenceName = "SEQ_CARRO", initialValue = 1)
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CARRO")
	private Long codigo;
	private String placa;
	private String cor;
	private String chassi;
	private BigDecimal valorDiaria;
	@ManyToOne
	@JoinColumn(name = "codigo_modelo")
	private ModeloCarro modelo;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "carro_acessorio"
			, joinColumns = @JoinColumn(name = "codigo_carro")
			, inverseJoinColumns = @JoinColumn(name = "codigo_acessorio"))
	private List<Acessorio> acessorios;
	@OneToMany(mappedBy = "carro")
	private List<Aluguel> alugueis;

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public ModeloCarro getModelo() {
		return modelo;
	}
	public void setModelo(ModeloCarro modelo) {
		this.modelo = modelo;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}
	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Carro)) return false;

		Carro carro = (Carro) o;

		return getCodigo().equals(carro.getCodigo());

	}

	@Override
	public int hashCode() {
		return getCodigo().hashCode();
	}
}
