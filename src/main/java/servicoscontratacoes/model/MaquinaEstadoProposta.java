package servicoscontratacoes.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBCO8009_MQNA_ESTD_PRPT", schema = "dbo")
@IdClass(ChaveMaquina.class)
public class MaquinaEstadoProposta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_PRPT_VEND")
	private Integer codPrptVend;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "COD_TIPO_ESTD_PRPT_INI", referencedColumnName = "COD_TIPO_ESTD_PRPT_VEND")
	private TipoEstadoPropostaVenda tipoEstadoPropostaVendaIni;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "COD_TIPO_ESTD_PRPT_FIM", referencedColumnName = "COD_TIPO_ESTD_PRPT_VEND")
	private TipoEstadoPropostaVenda tipoEstadoPropostaVendaFim;

	@Column(name = "DAT_HORA_MQNA_ESTD")
	private LocalDateTime datHoraMqnaEstd = LocalDateTime.now();

	public Integer getCodPrptVend() {
		return codPrptVend;
	}

	public void setCodPrptVend(Integer codPrptVend) {
		this.codPrptVend = codPrptVend;
	}

	public TipoEstadoPropostaVenda getTipoEstadoPropostaVendaIni() {
		return tipoEstadoPropostaVendaIni;
	}

	public void setTipoEstadoPropostaVendaIni(TipoEstadoPropostaVenda tipoEstadoPropostaVendaIni) {
		this.tipoEstadoPropostaVendaIni = tipoEstadoPropostaVendaIni;
	}

	public TipoEstadoPropostaVenda getTipoEstadoPropostaVendaFim() {
		return tipoEstadoPropostaVendaFim;
	}

	public void setTipoEstadoPropostaVendaFim(TipoEstadoPropostaVenda tipoEstadoPropostaVendaFim) {
		this.tipoEstadoPropostaVendaFim = tipoEstadoPropostaVendaFim;
	}

	public LocalDateTime getDatHoraMqnaEstd() {
		return datHoraMqnaEstd;
	}

	public void setDatHoraMqnaEstd(LocalDateTime datHoraMqnaEstd) {
		this.datHoraMqnaEstd = datHoraMqnaEstd;
	}

}

class ChaveMaquina implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer codPrptVend;
	private TipoEstadoPropostaVenda tipoEstadoPropostaVendaIni;
	private TipoEstadoPropostaVenda tipoEstadoPropostaVendaFim;
	
	public Integer getCodPrptVend() {
		return codPrptVend;
	}
	public void setCodPrptVend(Integer codPrptVend) {
		this.codPrptVend = codPrptVend;
	}
	public TipoEstadoPropostaVenda getTipoEstadoPropostaVendaIni() {
		return tipoEstadoPropostaVendaIni;
	}
	public void setTipoEstadoPropostaVendaIni(TipoEstadoPropostaVenda tipoEstadoPropostaVendaIni) {
		this.tipoEstadoPropostaVendaIni = tipoEstadoPropostaVendaIni;
	}
	public TipoEstadoPropostaVenda getTipoEstadoPropostaVendaFim() {
		return tipoEstadoPropostaVendaFim;
	}
	public void setTipoEstadoPropostaVendaFim(TipoEstadoPropostaVenda tipoEstadoPropostaVendaFim) {
		this.tipoEstadoPropostaVendaFim = tipoEstadoPropostaVendaFim;
	}
}

