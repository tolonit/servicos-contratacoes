package servicoscontratacoes.model;

import java.util.List;

public class PropostaVendaLista {

	private Integer idProposta;
	
	private TipoEstadoPropostaVenda tipoEstadoPropostaVenda ;
	
	private List<MaquinaEstadoProposta> maquinaEstadoProposta;
	

	public PropostaVendaLista(Integer idProposta, TipoEstadoPropostaVenda tipoEstadoPropostaVenda, List<MaquinaEstadoProposta> maquinaEstadoProposta) {
		this.idProposta = idProposta;
		this.tipoEstadoPropostaVenda = tipoEstadoPropostaVenda;
		this.maquinaEstadoProposta = maquinaEstadoProposta;
	}
	
	public Integer getIdProposta() {
		return idProposta;
	}

	public void setIdProposta(Integer idProposta) {
		this.idProposta = idProposta;
	}

	public TipoEstadoPropostaVenda getTipoEstadoPropostaVenda() {
		return tipoEstadoPropostaVenda;
	}

	public void setTipoEstadoPropostaVenda(TipoEstadoPropostaVenda tipoEstadoPropostaVenda) {
		this.tipoEstadoPropostaVenda = tipoEstadoPropostaVenda;
	}

	public List<MaquinaEstadoProposta> getMaquinaEstadoProposta() {
		return maquinaEstadoProposta;
	}

	public void setMaquinaEstadoProposta(List<MaquinaEstadoProposta> maquinaEstadoProposta) {
		this.maquinaEstadoProposta = maquinaEstadoProposta;
	}
	
}
