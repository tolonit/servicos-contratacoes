package br.com.itau.servicoscontratacoes.controller;

import java.net.URI;
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

import br.com.itau.servicoscontratacoes.controller.dto.DetalhePropostaVendaDto;
import br.com.itau.servicoscontratacoes.controller.dto.PropostaVendaDto;
import br.com.itau.servicoscontratacoes.controller.form.PropostaVendaForm;
import br.com.itau.servicoscontratacoes.model.MaquinaEstadoProposta;
import br.com.itau.servicoscontratacoes.model.PropostaVenda;
import br.com.itau.servicoscontratacoes.model.TipoEstadoPropostaVenda;
import br.com.itau.servicoscontratacoes.repository.MaquinaEstadoPropostaRepository;
import br.com.itau.servicoscontratacoes.repository.PropostaVendaRepository;
import br.com.itau.servicoscontratacoes.repository.TipoEstadoPropostaVendaRepository;

@RestController
@RequestMapping("/propostas")
public class PropostaVendaController {

	@Autowired
	private PropostaVendaRepository propostaVendaRepository;

	@Autowired
	private TipoEstadoPropostaVendaRepository tipoEstadoPropostaVendaRepository;

	@Autowired
	private MaquinaEstadoPropostaRepository maquinaEstadoPropostaRepository;
	
	@GetMapping
	public Page<PropostaVendaDto> lista(@PageableDefault(sort="codPrptVend",direction=Direction.ASC,page=0,size=10) Pageable paginacao) {
		Page<PropostaVenda> propostaVenda = propostaVendaRepository.findAll(paginacao);
		return PropostaVendaDto.converter(propostaVenda);
	}

	@GetMapping("/{id}")
	public DetalhePropostaVendaDto detalhar(@PathVariable Integer id ) {
		PropostaVenda propostaVenda = propostaVendaRepository.getOne(id);
		List<MaquinaEstadoProposta> maquinaEstado = maquinaEstadoPropostaRepository.findAllByCodPrptVend(id);
		TipoEstadoPropostaVenda tipoEstadoPropostaVenda = tipoEstadoPropostaVendaRepository.getOne(propostaVenda.getCodTipoEstdPrptVend());
		
		return new DetalhePropostaVendaDto(propostaVenda, maquinaEstado, tipoEstadoPropostaVenda);
	}
	
	@PostMapping
	public ResponseEntity<PropostaVendaDto> cadastrar(@RequestBody PropostaVendaForm form, UriComponentsBuilder uriBuilder) {
		PropostaVenda propostaVenda = form.converter(tipoEstadoPropostaVendaRepository);
		propostaVendaRepository.save(propostaVenda);
		
		URI uri = uriBuilder.path("/propostas/{id}").buildAndExpand(propostaVenda.getCodPrptVend()).toUri();
		return ResponseEntity.created(uri).body(new PropostaVendaDto(propostaVenda));
	}
		
	
}
