package servicoscontratacoes.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import servicoscontratacoes.controller.dto.PropostaVendaDetalheDto;
import servicoscontratacoes.controller.dto.PropostaVendaDto;
import servicoscontratacoes.controller.dto.PropostaVendaListaDto;
import servicoscontratacoes.controller.form.PropostaVendaForm;
import servicoscontratacoes.model.MaquinaEstadoProposta;
import servicoscontratacoes.model.PropostaVenda;
import servicoscontratacoes.model.PropostaVendaLista;
import servicoscontratacoes.model.TipoEstadoPropostaVenda;
import servicoscontratacoes.repository.MaquinaEstadoPropostaRepository;
import servicoscontratacoes.repository.PropostaVendaRepository;
import servicoscontratacoes.repository.TipoEstadoPropostaVendaRepository;

@RestController
@RequestMapping("/propostas")
public class PropostaVendaController {

	@Autowired
	private PropostaVendaRepository propostaVendaRepository;

	@Autowired
	private TipoEstadoPropostaVendaRepository tipoEstadoPropostaVendaRepository;

	@Autowired
	private MaquinaEstadoPropostaRepository maquinaEstadoPropostaRepository;
	
//	@GetMapping
//	public Page<PropostaVendaDto> lista(@PageableDefault(sort="codPrptVend",direction=Direction.ASC,page=0,size=10) Pageable paginacao) {
//		Page<PropostaVenda> propostaVenda = propostaVendaRepository.findAll(paginacao);
//		return PropostaVendaDto.converter(propostaVenda);
//	}

	@GetMapping
	public List<PropostaVendaListaDto> listarPropostas() {
		return PropostaVendaListaDto.converter(listaPropostas());
	}
	
	@GetMapping("/{id}")
	public PropostaVendaDetalheDto detalhar(@PathVariable Integer id ) {
		PropostaVenda propostaVenda = propostaVendaRepository.getOne(id);
		List<MaquinaEstadoProposta> maquinaEstado = maquinaEstadoPropostaRepository.findAllByCodPrptVend(id);
		TipoEstadoPropostaVenda tipoEstadoPropostaVenda = tipoEstadoPropostaVendaRepository.getOne(propostaVenda.getCodTipoEstdPrptVend());
		
		return new PropostaVendaDetalheDto(propostaVenda, maquinaEstado, tipoEstadoPropostaVenda);
	}
	
	@PostMapping
	public ResponseEntity<PropostaVendaDto> cadastrar(@RequestBody PropostaVendaForm form, UriComponentsBuilder uriBuilder) {
		PropostaVenda propostaVenda = form.converter(tipoEstadoPropostaVendaRepository);
		propostaVendaRepository.save(propostaVenda);
		
		URI uri = uriBuilder.path("/propostas/{id}").buildAndExpand(propostaVenda.getCodPrptVend()).toUri();
		return ResponseEntity.created(uri).body(new PropostaVendaDto(propostaVenda));
	}
	
	private List<PropostaVendaLista> listaPropostas() {
		
		List<PropostaVenda> propostaVenda = propostaVendaRepository.findAll();
		List<PropostaVendaLista> propostaVendaLista = new ArrayList<>(); 
				
		for (PropostaVenda item : propostaVenda) {
			
			propostaVendaLista.add(
					new PropostaVendaLista(item.getCodPrptVend(),
											tipoEstadoPropostaVendaRepository.getOne(item.getCodTipoEstdPrptVend()),
											maquinaEstadoPropostaRepository.findAllByCodPrptVend(item.getCodPrptVend())));
			
		}
		
		return propostaVendaLista;
	}
}
