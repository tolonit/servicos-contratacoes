package servicoscontratacoes.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import servicoscontratacoes.model.TipoEstadoPropostaVenda;

public class TipoEstadoPropostaVendaDto {

	private Integer id_estado;
	private String nome_estado;
	private String descricao_estado;
	
	public TipoEstadoPropostaVendaDto(TipoEstadoPropostaVenda tipoEstadoPropostaVenda) {
		this.id_estado = tipoEstadoPropostaVenda.getCodTipoEstdPrptVend();
		this.nome_estado = tipoEstadoPropostaVenda.getNomTipoEstdPrptVend().trim();
		this.descricao_estado = tipoEstadoPropostaVenda.getDesTipoEstdPrptVend().trim();
	}
	
	public static List<TipoEstadoPropostaVendaDto> converter(List<TipoEstadoPropostaVenda> tipoEstadoPropostaVendas) {
		return tipoEstadoPropostaVendas.stream()
				.map(TipoEstadoPropostaVendaDto::new)
				.collect(Collectors.toList());
	}

	public long getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

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
}
