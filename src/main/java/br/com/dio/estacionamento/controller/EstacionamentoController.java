package br.com.dio.estacionamento.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.estacionamento.config.EstacionamentoMapper;
import br.com.dio.estacionamento.model.Estacionamento;
import br.com.dio.estacionamento.model.dto.EstacionamentoDTO;
import br.com.dio.estacionamento.service.impl.EstacionamentoServiceImpl;

@RestController
@RequestMapping(value = "/estacionamento")
public class EstacionamentoController {

	private final EstacionamentoServiceImpl service;
	private final EstacionamentoMapper mapper;

	public EstacionamentoController(EstacionamentoServiceImpl service, EstacionamentoMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping
	public List<EstacionamentoDTO> findAll() {
		List<Estacionamento> estacionamentoLista = service.findAll();
		List<EstacionamentoDTO> result = mapper.toEstacionamentoDTOList(estacionamentoLista);

		return result;
	}
}
