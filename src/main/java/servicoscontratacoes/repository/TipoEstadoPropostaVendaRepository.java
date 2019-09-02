package br.com.itau.servicoscontratacoes.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.servicoscontratacoes.controller.form.TipoEstadoPropostaVendaForm;
import br.com.itau.servicoscontratacoes.model.TipoEstadoPropostaVenda;

public interface TipoEstadoPropostaVendaRepository extends JpaRepository<TipoEstadoPropostaVenda, Integer> {

	TipoEstadoPropostaVendaForm save(@Valid TipoEstadoPropostaVendaForm form);
	
	//@Query("SELECT MAX(COD_TIPO_ESTD_PRPT_VEND) FROM TipoEstadoPropostaVenda") 
	//Long getMaxId();
}
