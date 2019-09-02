package servicoscontratacoes.controller.form;

import servicoscontratacoes.model.PropostaVenda;
import servicoscontratacoes.repository.TipoEstadoPropostaVendaRepository;

public class PropostaVendaForm {

	private Integer id_estado;
	
	private Integer id_produto;

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public PropostaVenda converter(TipoEstadoPropostaVendaRepository tipoEstadoPropostaVendaRepository) {
//		TipoEstadoPropostaVenda tipoEstadoPropostaVenda = tipoEstadoPropostaVendaRepository
//															.findById(this.id_estado)
//															.orElse(new TipoEstadoPropostaVenda(this.id_estado,"",""));
		return new PropostaVenda(this.id_estado , this.id_produto);
	}

	
	
}
