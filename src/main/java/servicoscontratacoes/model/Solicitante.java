package servicoscontratacoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBCO8010_SOLI_PRPT", schema = "dbo")
public class Solicitante {
	
	@Id
	@Column(name = "COD_SOLI_PRPT")
	private Integer codSoliPrpt;
	
	@Column(name = "NOM_SOLI_PRPT")
	private String nomSoliPrpt;
	
	@Column(name = "NUM_DOC")
	private Long numDoc;

	public Integer getCodSoliPrpt() {
		return codSoliPrpt;
	}

	public void setCodSoliPrpt(Integer codSoliPrpt) {
		this.codSoliPrpt = codSoliPrpt;
	}

	public String getNomSoliPrpt() {
		return nomSoliPrpt;
	}

	public void setNomSoliPrpt(String nomSoliPrpt) {
		this.nomSoliPrpt = nomSoliPrpt;
	}

	public Long getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(Long numDoc) {
		this.numDoc = numDoc;
	}
	
	
}
