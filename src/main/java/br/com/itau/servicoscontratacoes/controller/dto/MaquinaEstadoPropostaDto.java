package br.com.itau.servicoscontratacoes.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.itau.servicoscontratacoes.model.MaquinaEstadoProposta;

public class MaquinaEstadoPropostaDto {

	private TipoEstadoPropostaVendaDto id_estado_ini;
	private TipoEstadoPropostaVendaDto id_estado_fim;
	private LocalDateTime data_hora_maquina;
	
	public MaquinaEstadoPropostaDto (MaquinaEstadoProposta maquinaEstadoProposta) {

		this.id_estado_ini = new TipoEstadoPropostaVendaDto(maquinaEstadoProposta.getTipoEstadoPropostaVendaIni());
		this.id_estado_fim = new TipoEstadoPropostaVendaDto(maquinaEstadoProposta.getTipoEstadoPropostaVendaFim());		
		this.data_hora_maquina = maquinaEstadoProposta.getDatHoraMqnaEstd();		
	}

	public static List<MaquinaEstadoPropostaDto> converter(List<MaquinaEstadoProposta> maquinaEstadoPropostas) {
		return maquinaEstadoPropostas.stream().map(MaquinaEstadoPropostaDto::new).collect(Collectors.toList());
	}

	public TipoEstadoPropostaVendaDto getId_estado_ini() {
		return id_estado_ini;
	}

	public void setId_estado_ini(TipoEstadoPropostaVendaDto id_estado_ini) {
		this.id_estado_ini = id_estado_ini;
	}

	public TipoEstadoPropostaVendaDto getId_estado_fim() {
		return id_estado_fim;
	}

	public void setId_estado_fim(TipoEstadoPropostaVendaDto id_estado_fim) {
		this.id_estado_fim = id_estado_fim;
	}

	public LocalDateTime getData_hora_maquina() {
		return data_hora_maquina;
	}

	public void setData_hora_maquina(LocalDateTime data_hora_maquina) {
		this.data_hora_maquina = data_hora_maquina;
	}


	
}
