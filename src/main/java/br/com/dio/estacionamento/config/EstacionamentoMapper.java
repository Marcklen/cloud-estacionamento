package br.com.dio.estacionamento.config;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.dio.estacionamento.model.Estacionamento;
import br.com.dio.estacionamento.model.dto.EstacionamentoDTO;

@Component
public class EstacionamentoMapper {
	
	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public EstacionamentoDTO toEstacionamentoDTO(Estacionamento est) {
		return MODEL_MAPPER.map(est, EstacionamentoDTO.class);
	}

	public List<EstacionamentoDTO> toEstacionamentoDTOList(List<Estacionamento> estacionamentoLista) {
		return estacionamentoLista.stream().map(this::toEstacionamentoDTO).collect(Collectors.toList());
	}
}