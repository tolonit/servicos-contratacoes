package br.com.itau.servicoscontratacoes.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.itau.servicoscontratacoes.model.TipoEstadoPropostaVenda;

public class TipoEstadoPropostaVendaForm {

	@NotNull @NotEmpty
	private String nome_estado;
	
	@NotNull @NotEmpty
	private String descricao_estado;
	
	public String getNome_estado() {
		return nome_estado;
	}

	public void setNome_estado(String nome_estado) {
		this.nome_estado = nome_estado;
	}

	public String getDescricao_estado() {
		return descricao_estado;
	}

	public void setDescricao_estado(String descricao_estado) {
		this.descricao_estado = descricao_estado;
	}
	
	public TipoEstadoPropostaVenda converter() {
		return new TipoEstadoPropostaVenda(nome_estado, descricao_estado);
	}
	
	
}
