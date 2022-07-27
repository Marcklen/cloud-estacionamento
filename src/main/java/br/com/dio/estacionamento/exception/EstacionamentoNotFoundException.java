package br.com.dio.estacionamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EstacionamentoNotFoundException extends RuntimeException{

	public EstacionamentoNotFoundException(String id) {
		// TODO Auto-generated constructor stub
		super("Nao foi possível encontrar o carro estacionado pelo ID: " + id);
	}
}
