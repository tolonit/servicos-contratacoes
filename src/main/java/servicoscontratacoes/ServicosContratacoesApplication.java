package br.com.itau.servicoscontratacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ServicosContratacoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicosContratacoesApplication.class, args);
	}

}
