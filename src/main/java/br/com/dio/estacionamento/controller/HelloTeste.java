package br.com.dio.estacionamento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value = "/teste")
@ApiIgnore
public class HelloTeste {

	@GetMapping
	public String getHello() {
		return "OLA TESTE!";
	}
}
