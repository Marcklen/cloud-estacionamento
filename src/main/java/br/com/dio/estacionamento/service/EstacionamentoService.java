package br.com.dio.estacionamento.service;

import java.util.List;

import br.com.dio.estacionamento.model.Estacionamento;

public interface EstacionamentoService {
	
	List<Estacionamento> findAll();
	Estacionamento findById(String id);
	Estacionamento create(Estacionamento novoEstacionamento);
	void delete(String id);
	Estacionamento update(String id, Estacionamento atualizarEstacionamento);
	Estacionamento exit (String id);
}
