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

@Service
public class EstacionamentoServiceImpl { // implements EstacionamentoService{

	private static Map<String, Estacionamento> estacionamentoMap = new HashMap();

	static {
		var id = getUUID();
		var id1 = getUUID();
		Estacionamento est = new Estacionamento(id, "PMD-1234", "CE", "HYUNDAI", "CRETA", "PRETO");
		Estacionamento est2 = new Estacionamento(id1, "HGX-5678", "SP", "TOYOTA", "SW-4", "BRANCO-PEROLA");
		estacionamentoMap.put(id, est);
		estacionamentoMap.put(id1, est2);
	}

	public List<Estacionamento> findAll() {
		return estacionamentoMap.values().stream().collect(Collectors.toList());
	}

	public Estacionamento findById(String id) {
		// TODO Auto-generated method stub
		Estacionamento estacionamento = estacionamentoMap.get(id);
		if (estacionamento == null) {
			throw new EstacionamentoNotFoundException(id);
		}
		return estacionamentoMap.get(id);

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
		estacionamentoMap.put(uuid, novoEstacionamento);
		return novoEstacionamento;
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		//Estacionamento estacionamento = 
		findById(id);
		estacionamentoMap.remove(id);
	}

	public Estacionamento update(String id, Estacionamento atualizarEstacionamento) {
		// TODO Auto-generated method stub
		Estacionamento estacionamento = findById(id);
		estacionamento.setCor(atualizarEstacionamento.getCor());
		estacionamentoMap.replace(id, estacionamento);
		return estacionamento;
	}
}