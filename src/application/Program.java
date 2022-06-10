package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.ContratoPorHora;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Entre com o nome do departamento: ");
		// LEIO E INSTANCIO DEPARTAMENTO
		String nomeDepartamento = sc.nextLine();
		Departamento departamento = new Departamento(nomeDepartamento);
		System.out.println("");
		// LEIO E INSTANCIO TRABALHADOR
		System.out.println("Entre com os dados do trabalhador: ");
		String nomeTrabalhador;
		String nivel;
		double salarioBase;
		System.out.print("Nome: ");
		nomeTrabalhador = sc.nextLine();
		System.out.print("Nivel: ");
		nivel = sc.nextLine();
		NivelTrabalhador nivelTrabalhador = NivelTrabalhador.valueOf(nivel);
		System.out.print("Salario base: ");
		salarioBase = sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, nivelTrabalhador, salarioBase, departamento);
		System.out.println("");
		int qtdContratos;
		System.out.print("Quantos contratos esse trabalhador tera? ");
		qtdContratos = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<qtdContratos;i++) {
			System.out.println("Entre com os dados do contrato #" + (i + 1));
			System.out.print("Data (DD/MM/YYYY): ");
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String d = sc.nextLine();
			Date data = formatter.parse(d);
			
			double valorPorHora;
			System.out.print("Valor por hora: ");
			valorPorHora = sc.nextDouble();
			
			int duracao;
			System.out.print("Duracao: ");
			duracao = sc.nextInt();
			System.out.println("");
			sc.nextLine();
			
			ContratoPorHora contratoPorHora = new ContratoPorHora(data, valorPorHora, duracao);
			trabalhador.getContratos().add(contratoPorHora);
			System.out.println("");
		}
		System.out.print("Entre com o mes e o ano para calcular a renda: ");
		String mesAno = sc.nextLine();
		String[] list = mesAno.split("/");
		Integer mes = Integer.parseInt(list[0]);
		Integer ano = Integer.parseInt(list[1]);
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getName());
		System.out.println("Renda por "+mesAno+": " + trabalhador.renda(ano, mes));
		
	}

}
