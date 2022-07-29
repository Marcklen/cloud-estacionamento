package br.com.dio.estacionamento.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.estacionamento.config.EstacionamentoMapper;
import br.com.dio.estacionamento.model.Estacionamento;
import br.com.dio.estacionamento.model.dto.EstacionamentoDTO;
import br.com.dio.estacionamento.model.dto.EstacionamentoFormDTO;
import br.com.dio.estacionamento.service.impl.EstacionamentoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/estacionamento")
@Api(tags = "Estacionamento Controller")
public class EstacionamentoController {

	private final EstacionamentoServiceImpl service;
	private final EstacionamentoMapper mapper;

	public EstacionamentoController(EstacionamentoServiceImpl service, EstacionamentoMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping
	@ApiOperation("Buscar Todos Carros Estacionados")
	public ResponseEntity<List<EstacionamentoDTO>> findAll() {
		List<Estacionamento> estacionamentoLista = service.findAll();
		List<EstacionamentoDTO> result = mapper.toEstacionamentoDTOList(estacionamentoLista);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/{id}")
	@ApiOperation("Buscar Carro Estacionado por um ID")
	public ResponseEntity<EstacionamentoDTO> findById(@PathVariable String id) {
		Estacionamento estacionamento = service.findById(id);
		EstacionamentoDTO result = mapper.toEstacionamentoDTO(estacionamento);

		return ResponseEntity.ok(result);
	}
	
	@PostMapping
	@ApiOperation("Salvar carro no estacionamento")
	public ResponseEntity<EstacionamentoDTO> create(@RequestBody EstacionamentoFormDTO dto ) {
		Estacionamento novoEstacionamento = mapper.toEstacionamentoForm(dto);
		Estacionamento estacionamento = service.create(novoEstacionamento);
		EstacionamentoDTO result = mapper.toEstacionamentoDTO(estacionamento);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("Excluir carro estacionado")
	public ResponseEntity delete(@PathVariable String id) {
		//Estacionamento estacionamento = 
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	@ApiOperation("Atualizar SE houver erros, um carro estacionado")
	public ResponseEntity<EstacionamentoDTO> update (@PathVariable String id, @RequestBody EstacionamentoFormDTO dto) {
		Estacionamento atualizarEstacionamento = mapper.toEstacionamentoForm(dto);
		Estacionamento estacionamento = service.update(id, atualizarEstacionamento);
		
		return ResponseEntity.ok(mapper.toEstacionamentoDTO(estacionamento));
	}
	
	@PostMapping("/{id}")
	@ApiOperation("Calcular valor a pagar de carro estacionado")
	public ResponseEntity<EstacionamentoDTO> exit (@PathVariable String id) {
		Estacionamento estacionamento = service.exit(id);
		return ResponseEntity.ok(mapper.toEstacionamentoDTO(estacionamento));
	}
}