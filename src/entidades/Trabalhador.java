package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelTrabalhador;

public class Trabalhador {
	
	private String nome;
	private NivelTrabalhador nivel;
	private double baseSalarial;
	private Departamento departamento;
	private List<ContratoPorHora> contratos = new ArrayList<>();
	
	public Trabalhador(){	
	}
	
	public Trabalhador(String nome, NivelTrabalhador nivel, double baseSalarial, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.baseSalarial = baseSalarial;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public double getBaseSalarial() {
		return baseSalarial;
	}

	public void setBaseSalarial(double baseSalarial) {
		this.baseSalarial = baseSalarial;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoPorHora> getContratos() {
		return contratos;
	}
	
	public void addContrato(ContratoPorHora contrato){
		contratos.add(contrato);
	}
	public void removeContrato(ContratoPorHora contrato){
		contratos.remove(contrato);
	}
	public double renda (int ano, int mes){
		double soma = baseSalarial;
		Calendar cal = Calendar.getInstance(); 
		for(ContratoPorHora y : contratos){
			cal.setTime(y.getData());
			int y_ano = cal.get(Calendar.YEAR);
			int y_mes = cal.get(Calendar.MONTH);
			if(ano == y_ano && mes == y_mes + 1 ){
				soma+= y.valorTotal();
			}
		}
		return soma;
	}
	
	
	
}
