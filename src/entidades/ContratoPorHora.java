package entidades;

import java.util.Date;

public class ContratoPorHora {
	private Date data;
	private double valorPorHora;
	private Integer duracao;
	
	public ContratoPorHora (){
	}
	
	public ContratoPorHora(Date data, double valorPorHora, Integer duracao) {
		super();
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.duracao = duracao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
	public double valorTotal(){
		return valorPorHora*duracao;
	}
}
