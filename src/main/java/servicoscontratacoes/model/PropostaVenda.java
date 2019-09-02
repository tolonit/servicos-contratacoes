package servicoscontratacoes.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import servicoscontratacoes.controller.dto.MaquinaEstadoPropostaDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TBCO8008_PRPT_VEND", schema = "dbo")
public class PropostaVenda {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COD_PRPT_VEND")
	private Integer codPrptVend;
	
	@Column(name="COD_TIPO_ESTD_PRPT_VEND")
	private Integer codTipoEstdPrptVend;
	
	@Column(name="COD_PRDT_VEND")
	private Integer codProdPrptVend;

	public PropostaVenda() {}
	
	public PropostaVenda(Integer idEstado, Integer idProduto) {
		this.codTipoEstdPrptVend = idEstado;
		this.codProdPrptVend = idProduto;
	}

	public Integer getCodPrptVend() {
		return codPrptVend;
	}

	public void setCodPrptVend(Integer codPrptVend) {
		this.codPrptVend = codPrptVend;
	}

	public Integer getCodTipoEstdPrptVend() {
		return codTipoEstdPrptVend;
	}

	public void setCodTipoEstdPrptVend(Integer codTipoEstdPrptVend) {
		this.codTipoEstdPrptVend = codTipoEstdPrptVend;
	}

	public Integer getCodProdPrptVend() {
		return codProdPrptVend;
	}

	public void setCodProdPrptVend(Integer codProdPrptVend) {
		this.codProdPrptVend = codProdPrptVend;
	}

	public Collection<MaquinaEstadoPropostaDto> getHistoricoEstados() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
