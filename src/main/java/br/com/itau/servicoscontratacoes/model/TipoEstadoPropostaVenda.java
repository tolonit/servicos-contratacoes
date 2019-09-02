package br.com.itau.servicoscontratacoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TBCO8007_TIPO_ESTD_PRPT_VEND", schema = "dbo")
public class TipoEstadoPropostaVenda {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COD_TIPO_ESTD_PRPT_VEND")
	private Integer codTipoEstdPrptVend;
	
	@Column(name="NOM_TIPO_ESTD_PRPT_VEND")	
	private String nomTipoEstdPrptVend;
	
	@Column(name="DES_TIPO_ESTD_PRPT_VEND")	
	private String desTipoEstdPrptVend;
	
	public TipoEstadoPropostaVenda() {}
	
	public TipoEstadoPropostaVenda(String nome_estado, String descricao_estado) {
		this.nomTipoEstdPrptVend = nome_estado;
		this.desTipoEstdPrptVend = descricao_estado;
	}

	public TipoEstadoPropostaVenda(Integer id_estado, String nome_estado, String descricao_estado) {
		this.codTipoEstdPrptVend = id_estado;
		this.nomTipoEstdPrptVend = nome_estado;
		this.desTipoEstdPrptVend = descricao_estado;
	}

	public Integer getCodTipoEstdPrptVend() {
		return codTipoEstdPrptVend;
	}

	public void setCodTipoEstdPrptVend(Integer codTipoEstdPrptVend) {
		this.codTipoEstdPrptVend = codTipoEstdPrptVend;
	}

	public String getNomTipoEstdPrptVend() {
		return nomTipoEstdPrptVend;
	}

	public void setNomTipoEstdPrptVend(String nomTipoEstdPrptVend) {
		this.nomTipoEstdPrptVend = nomTipoEstdPrptVend;
	}

	public String getDesTipoEstdPrptVend() {
		return desTipoEstdPrptVend;
	}

	public void setDesTipoEstdPrptVend(String desTipoEstdPrptVend) {
		this.desTipoEstdPrptVend = desTipoEstdPrptVend;
	}
	

}
