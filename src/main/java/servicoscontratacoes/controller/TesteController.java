package br.com.itau.servicoscontratacoes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

	@GetMapping
	public String Teste () {
		return "Teste Controller";
	}
}
