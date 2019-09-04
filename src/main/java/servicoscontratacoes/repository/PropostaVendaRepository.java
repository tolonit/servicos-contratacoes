package servicoscontratacoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import servicoscontratacoes.model.PropostaVenda;

public interface PropostaVendaRepository extends JpaRepository<PropostaVenda, Integer>{

	@Query("SELECT new PropostaVenda(a.codPrptVend, a.codTipoEstdPrptVend, a.codProdPrptVend) "
	+ "FROM PropostaVenda a "
	+ "WHERE a.codProdPrptVend IN (SELECT b.codSoliPrpt FROM Solicitante b WHERE b.numDoc = ?1 ) "
	+ "AND a.codTipoEstdPrptVend = ?2" )
	List<PropostaVenda> consultaTeste(Long cpf, Integer produto);

}

