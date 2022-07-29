package br.com.dio.estacionamento.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import br.com.dio.estacionamento.model.Estacionamento;

public class EstacionamentoConta {

	public static final int UMA_HORA = 60;
	public static final int VINTE_QUATRO_HORAS = 24 * UMA_HORA;
	public static final double VALOR_HORA = 5.00;
	public static final double VALOR_HORA_ADICIONAL = 2.00;
	public static final double VALOR_DIARIA = 20.00;

	public static Double getConta(Estacionamento estacionamento) {
		return getConta(estacionamento.getDataEntrada(), estacionamento.getDataSaida());
	}

	private static Double getConta(LocalDateTime dataEntrada, LocalDateTime dataSaida) {
		// TODO Auto-generated method stub
		long minutos = dataEntrada.until(dataSaida, ChronoUnit.MINUTES);
		Double conta = 0.0;
		//aqui será cobrado o valor de 1 hora independente de ter ficado 60 minutos ou nao
		if (minutos <= UMA_HORA) {
			return VALOR_HORA;
		}
		//passando menos de 1 dia estacionado com retirada do veiculo
		if (minutos <= VINTE_QUATRO_HORAS) {
			conta = VALOR_HORA;
			int horas = (int) (minutos / UMA_HORA);
			System.out.println(horas);
			for (int i = 0; i < horas; i++) {
				conta += VALOR_HORA_ADICIONAL;
			}
			return conta;
		}
		//se passar mais de 1 dia estacionado
		int dias = (int) (minutos / VINTE_QUATRO_HORAS);
		//System.out.println(dias);
		for (int i = 0; i < dias; i++) {
			conta += VALOR_DIARIA;
		}
		return conta;
	}
}
