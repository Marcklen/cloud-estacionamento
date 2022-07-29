package br.com.dio.estacionamento.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dio.estacionamento.exception.EstacionamentoNotFoundException;
import br.com.dio.estacionamento.model.Estacionamento;
import br.com.dio.estacionamento.repository.EstacionamentoRepository;
import br.com.dio.estacionamento.service.EstacionamentoService;

@Service
public class EstacionamentoServiceImpl implements EstacionamentoService{

	private final EstacionamentoRepository repository;

	public EstacionamentoServiceImpl(EstacionamentoRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Estacionamento> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

    @Transactional(readOnly = true)
    @Override
	public Estacionamento findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(
				() -> new EstacionamentoNotFoundException(id));
	}

	public static String getUUID() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString().replace("-", "");
	}

	@Transactional
	@Override
	public Estacionamento create(Estacionamento novoEstacionamento) {
		// TODO Auto-generated method stub
		String uuid = getUUID();
		novoEstacionamento.setId(uuid);
		novoEstacionamento.setDataEntrada(LocalDateTime.now());
		repository.save(novoEstacionamento);
		return novoEstacionamento;
	}

	@Transactional
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		findById(id);
		repository.deleteById(id);
	}

	@Transactional
	@Override
	public Estacionamento update(String id, Estacionamento atualizarEstacionamento) {
		// TODO Auto-generated method stub
		Estacionamento estacionamento = findById(id);
		estacionamento.setCor(atualizarEstacionamento.getCor());
		repository.save(estacionamento);
		return estacionamento;
	}
	
	@Transactional
	@Override
	public Estacionamento exit (String id) {
		//recuperando o carro estacionado
		Estacionamento estacionamento = findById(id);
		//atualizando a data de saida
		estacionamento.setDataSaida(LocalDateTime.now());
		//calculando o valor a pagar
		estacionamento.setValor(EstacionamentoConta.getConta(estacionamento));
		repository.save(estacionamento);
		return estacionamento;
	}
}