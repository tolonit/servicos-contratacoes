package br.com.itau.servicoscontratacoes.controller.dto;

import java.util.List;

import br.com.itau.servicoscontratacoes.model.MaquinaEstadoProposta;
import br.com.itau.servicoscontratacoes.model.PropostaVenda;
import br.com.itau.servicoscontratacoes.model.TipoEstadoPropostaVenda;

public class DetalhePropostaVendaDto {

	private Integer id_proposta;
	private TipoEstadoPropostaVendaDto estado_atual_proposta;
	private Integer id_produto;
	private List<MaquinaEstadoPropostaDto> maquina_estado;
		
	public DetalhePropostaVendaDto(PropostaVenda propostaVenda, 
								List<MaquinaEstadoProposta> maquinaEstadoProposta,
								TipoEstadoPropostaVenda tipoEstadoPropostaVenda ) {

		this.id_proposta = propostaVenda.getCodPrptVend();
		this.estado_atual_proposta = new TipoEstadoPropostaVendaDto(tipoEstadoPropostaVenda);
		this.id_produto = propostaVenda.getCodProdPrptVend();
		this.maquina_estado = MaquinaEstadoPropostaDto.converter(maquinaEstadoProposta);
	}

	public Integer getId_proposta() {
		return id_proposta;
	}

	public void setId_proposta(Integer id_proposta) {
		this.id_proposta = id_proposta;
	}

	public TipoEstadoPropostaVendaDto getEstado_atual_proposta() {
		return estado_atual_proposta;
	}

	public void setEstado_atual_proposta(TipoEstadoPropostaVendaDto estado_atual_proposta) {
		this.estado_atual_proposta = estado_atual_proposta;
	}

	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public List<MaquinaEstadoPropostaDto> getMaquina_estado() {
		return maquina_estado;
	}

	public void setMaquina_estado(List<MaquinaEstadoPropostaDto> maquina_estado) {
		this.maquina_estado = maquina_estado;
	}


	
}
