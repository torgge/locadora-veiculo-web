package com.algaworks.curso.jpa2.controller;

import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.service.CadastroAcessorioService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CadastroAcessorioBean implements Serializable {

	@Inject
	private CadastroAcessorioService cadastroAcessorioService;

	private Acessorio acessorio;
	
	public void salvar() {
		try {
			this.cadastroAcessorioService.salvar(acessorio);
			FacesUtil.addSuccessMessage("Acessório salvo com sucesso!");

			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	@PostConstruct
	public void init() {
		this.limpar();
	}

	public void limpar() {
		this.acessorio = new Acessorio();
	}

	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}
	
}
