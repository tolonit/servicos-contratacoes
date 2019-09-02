package br.com.itau.servicoscontratacoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.itau.servicoscontratacoes.model.MaquinaEstadoProposta;

public interface MaquinaEstadoPropostaRepository extends JpaRepository<MaquinaEstadoProposta, Integer>{

	List<MaquinaEstadoProposta> findAllByCodPrptVend(Integer id);
}
