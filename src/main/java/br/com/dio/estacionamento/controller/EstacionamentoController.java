package br.com.dio.estacionamento.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.estacionamento.model.Estacionamento;

@RestController
@RequestMapping(value = "/estacionamento")
public class EstacionamentoController {

	@GetMapping
	public List<Estacionamento> findAll() { 
		Estacionamento estacionamento = new Estacionamento();
		estacionamento.setId(1);
		estacionamento.setCor("PRETO");
		estacionamento.setMarca("HYUNDAI");
		estacionamento.setModelo("CRETA 16A PULSE");
		estacionamento.setPlaca("ABC-1234");
				
		return Arrays.asList(estacionamento, estacionamento);
	}
}
