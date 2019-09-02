package servicoscontratacoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import servicoscontratacoes.model.MaquinaEstadoProposta;

public interface MaquinaEstadoPropostaRepository extends JpaRepository<MaquinaEstadoProposta, Integer>{

	List<MaquinaEstadoProposta> findAllByCodPrptVend(Integer id);
}
