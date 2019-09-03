package servicoscontratacoes.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import servicoscontratacoes.model.PropostaVendaLista;

public class PropostaVendaListaDto {

	private Integer id_proposta;
	private TipoEstadoPropostaVendaDto estado_atual_proposta;
	//private Integer id_produto;
	private List<MaquinaEstadoPropostaDto> maquina_estado;
	
	public PropostaVendaListaDto(PropostaVendaLista propostaVendaLista) {
		this.id_proposta = propostaVendaLista.getIdProposta();
		this.estado_atual_proposta = new TipoEstadoPropostaVendaDto(propostaVendaLista.getTipoEstadoPropostaVenda());
		//this.id_produto
		this.maquina_estado = MaquinaEstadoPropostaDto.converter(propostaVendaLista.getMaquinaEstadoProposta());
	}
	
	public static List<PropostaVendaListaDto> converter(List<PropostaVendaLista> propostaVendaLista) {
		return propostaVendaLista.stream()
				.map(PropostaVendaListaDto::new)
				.collect(Collectors.toList());
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

	public List<MaquinaEstadoPropostaDto> getMaquina_estado() {
		return maquina_estado;
	}

	public void setMaquina_estado(List<MaquinaEstadoPropostaDto> maquina_estado) {
		this.maquina_estado = maquina_estado;
	}
	
	

}
