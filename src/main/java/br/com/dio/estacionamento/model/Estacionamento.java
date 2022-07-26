package br.com.dio.estacionamento.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "ESTACIONAMENTO_TB")
public class Estacionamento {

	@Id
	private String id;
	private String placa;
	private String estado;
	private String marca;
	private String modelo;
	private String cor;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private Double valor;

	public Estacionamento(String id, String placa, String estado, String marca, String modelo, String cor) {
		this.id = id;
		this.placa = placa;
		this.estado = estado;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
	}

	public Estacionamento() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
