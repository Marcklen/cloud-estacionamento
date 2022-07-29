package br.com.dio.estacionamento.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.dio.estacionamento.exception.EstacionamentoNotFoundException;
import br.com.dio.estacionamento.model.Estacionamento;
import br.com.dio.estacionamento.repository.EstacionamentoRepository;

@Service
public class EstacionamentoServiceImpl { // implements EstacionamentoService{

	private final EstacionamentoRepository repository;

	public EstacionamentoServiceImpl(EstacionamentoRepository repository) {
		this.repository = repository;
	}

	public List<Estacionamento> findAll() {
		return repository.findAll();
	}

	public Estacionamento findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(
				() -> new EstacionamentoNotFoundException(id));
	}

	public static String getUUID() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString().replace("-", "");
	}

	public Estacionamento create(Estacionamento novoEstacionamento) {
		// TODO Auto-generated method stub
		String uuid = getUUID();
		novoEstacionamento.setId(uuid);
		novoEstacionamento.setDataEntrada(LocalDateTime.now());
		repository.save(novoEstacionamento);
		return novoEstacionamento;
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		findById(id);
		repository.deleteById(id);
	}

	public Estacionamento update(String id, Estacionamento atualizarEstacionamento) {
		// TODO Auto-generated method stub
		Estacionamento estacionamento = findById(id);
		estacionamento.setCor(atualizarEstacionamento.getCor());
		repository.save(estacionamento);
		return estacionamento;
	}
}