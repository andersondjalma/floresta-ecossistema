package br.uninassau.util;

import java.util.Scanner;

public class Configuracoes {
	private int valorProp;
	private int quantidadeTigre;
	private int quantidadeCoelho;
	private int quantidadeArvore;
	private int control;
	private boolean controlWhile = false;
	
	//Construtor que recebe um objeto Scanner para interagir com o usuário
	public Configuracoes(Scanner in) {
		menuInicial(in);
	}
	
	//Getter para obter algumas informações
	public int getTamanhoMapa() {
		return valorProp;
	}
	public int getquantidadeArvore() {
		return quantidadeArvore;
	}
	public int getquantidadeTigre() {
		return quantidadeTigre;
	}
	public int getquantidadeCoelho() {
		return quantidadeCoelho;
	}
	
	//Método para exibir o menu inicial
	public void menuInicial(Scanner in) {
		do {
			System.out.println("+-------------------+");
			System.out.println("|Menu do Ecossistema|");
			System.out.println("+-------------------+");
			System.out.println("1 - Faca a sua configuracao");
			System.out.println("2 - Finalizar");
			System.out.print("Digite aqui: ");
			control = in.nextInt();
			if (control == 1) {
				suaConfig(in);
				controlWhile = false;
			} else if (control == 2) {
				System.exit(0);
				controlWhile = false;
			} else {
				controlWhile = true;
			}
		} while (controlWhile);

	}

	//Método para configurar o tamanho do mapa e a quantidade de animais/plantas
	public void suaConfig(Scanner in) {
		int quantidadeMaxTigre = 0;
		int quantidadeMaxCoelho = 0;
		int quantidadeMaxArvore = 0;
		do {
			System.out.println("");
			System.out.println("+---------------------+");
			System.out.println("|Menu de Configuracoes|");
			System.out.println("+---------------------+");
			System.out.println("Qual o tamanho do mapa:");
			System.out.println("1 - 10x10");
			System.out.println("2 - 12x12");
			System.out.println("3 - 16x16");
			System.out.print("Digite aqui: ");
			control = in.nextInt();
			if (control == 1) {
				valorProp = 10;
				quantidadeMaxTigre = 5;
				quantidadeMaxCoelho = 14;
				quantidadeMaxArvore = 18;
			} else if (control == 2) {
				valorProp = 12;
				quantidadeMaxTigre = 7;
				quantidadeMaxCoelho = 20;
				quantidadeMaxArvore = 25;
			} else if (control == 3) {
				valorProp = 16;
				quantidadeMaxTigre = 10;
				quantidadeMaxCoelho = 30;
				quantidadeMaxArvore = 38;
			} 
		} while (control != 1 && control != 2 && control != 3 && control != 4);
		do {
			System.out.println("");
			System.out.printf("Qual a quantidade de tigre(s)?: ", quantidadeMaxTigre);
			quantidadeTigre = in.nextInt();
		} while (quantidadeTigre > quantidadeMaxTigre);
		do {
			System.out.printf("Qual a quantidade de coelho(s)?: ", quantidadeMaxCoelho);
			quantidadeCoelho = in.nextInt();
		} while (quantidadeCoelho > quantidadeMaxCoelho);
		do {
			System.out.printf("Qual a quantidade de arvore(s)?: ", quantidadeMaxArvore);
			quantidadeArvore = in.nextInt();
		} while (quantidadeArvore > quantidadeMaxArvore);
		System.out.println("");
	}
}