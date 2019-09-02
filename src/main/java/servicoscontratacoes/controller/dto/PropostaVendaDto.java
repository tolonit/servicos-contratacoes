package servicoscontratacoes.controller.dto;

import org.springframework.data.domain.Page;

import servicoscontratacoes.model.PropostaVenda;

public class PropostaVendaDto {

	private Integer id_proposta;
	private Integer estado_proposta;
	private Integer id_produto;
	
	public PropostaVendaDto () {}
	
	public PropostaVendaDto(PropostaVenda propostaVenda) {
		this.id_proposta = propostaVenda.getCodPrptVend();
		this.estado_proposta = propostaVenda.getCodTipoEstdPrptVend();
		this.id_produto = propostaVenda.getCodProdPrptVend();
	}
	
	public static Page<PropostaVendaDto> converter(Page<PropostaVenda> propostaVenda) {
		return propostaVenda.map(PropostaVendaDto::new);
	}

	public Integer getId_proposta() {
		return id_proposta;
	}

	public void setId_proposta(Integer id_proposta) {
		this.id_proposta = id_proposta;
	}

	public Integer getEstado_proposta() {
		return estado_proposta;
	}

	public void setEstado_proposta(Integer estado_proposta) {
		this.estado_proposta = estado_proposta;
	}

	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}
	


}