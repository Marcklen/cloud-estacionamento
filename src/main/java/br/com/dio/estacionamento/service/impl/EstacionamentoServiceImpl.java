package br.com.dio.estacionamento.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.dio.estacionamento.model.Estacionamento;

@Service
public class EstacionamentoServiceImpl { // implements EstacionamentoService{

	private static Map<String, Estacionamento> estacionamentoMap = new HashMap();

	static {
		var id = getUUID();
		Estacionamento est = new Estacionamento(getUUID(), "PMD-1234", "CE", "HYUNDAI", "CRETA", "PRETO");
		estacionamentoMap.put(id, est);
	}

	public List<Estacionamento> findAll() {
		return estacionamentoMap.values().stream().collect(Collectors.toList());
	}

	public static String getUUID() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString().replace("-", "");
	}
}