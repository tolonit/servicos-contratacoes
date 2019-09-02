package servicoscontratacoes.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import servicoscontratacoes.controller.dto.TipoEstadoPropostaVendaDto;
import servicoscontratacoes.controller.form.TipoEstadoPropostaVendaForm;
import servicoscontratacoes.model.TipoEstadoPropostaVenda;
import servicoscontratacoes.repository.TipoEstadoPropostaVendaRepository;

@RestController
@RequestMapping
public class TipoEstadoPropostaVendaController {

	@Autowired
	private TipoEstadoPropostaVendaRepository tipoEstadoPropostaVendaRepository;
	
	@GetMapping
	public List<TipoEstadoPropostaVendaDto> findAll(){
		List<TipoEstadoPropostaVenda> tipoEstadoPropostaVenda = tipoEstadoPropostaVendaRepository.findAll();
		return TipoEstadoPropostaVendaDto.converter(tipoEstadoPropostaVenda);
	}
	
	@PostMapping
	public ResponseEntity<TipoEstadoPropostaVendaDto> cadastrar(@RequestBody TipoEstadoPropostaVendaForm form, UriComponentsBuilder uriBuilder) {
		//long lastId = tipoEstadoPropostaVendaRepository.getMaxId(); lastId++;
		TipoEstadoPropostaVenda tipoEstadoPropostaVenda = form.converter();
		tipoEstadoPropostaVendaRepository.save(tipoEstadoPropostaVenda);
		
		URI uri = uriBuilder.path("{id}").buildAndExpand(tipoEstadoPropostaVenda.getCodTipoEstdPrptVend()).toUri();
		return ResponseEntity.created(uri).body(new TipoEstadoPropostaVendaDto(tipoEstadoPropostaVenda));
	}
	
	@GetMapping("/{id}")
	public TipoEstadoPropostaVendaDto detalhar(@PathVariable Integer id) {
		TipoEstadoPropostaVenda tipoEstadoPropostaVenda = tipoEstadoPropostaVendaRepository.getOne(id);
		return new TipoEstadoPropostaVendaDto(tipoEstadoPropostaVenda);
	}

	@DeleteMapping("/{id}")
	public void apagar(@PathVariable Integer id) {
		this.tipoEstadoPropostaVendaRepository.deleteById(id);
	}	

}
