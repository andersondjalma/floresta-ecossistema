package br.uninassau.util;

import java.util.Scanner;

public class Configuracoes {
	private int valorProp;
	private int quantidadeTigre;
	private int quantidadeCoelho;
	private int quantidadeArvore;
	private int control;
	private boolean controlWhile = false;
	
	public Configuracoes() {
	}
	
	public Configuracoes(Scanner in) {
		menuInicial(in);
	}
	
	public int getTamanhoMapa() {
		return valorProp;
	}
	
	public int quantidadeArvore() {
		return quantidadeArvore;
	}
	
	public int getquantidadeTigre() {
		return quantidadeTigre;
	}
	
	public int getquantidadeCoelho() {
		return quantidadeCoelho;
	}
	
	public void menuInicial(Scanner in) {
		do {
			System.out.println("+-------------------------------------------+");
			System.out.println("|    Sejam bem vindos ao Meu Ecossistema!   |");
			System.out.println("+-------------------------------------------+");
			System.out.println("1 - Faca a sua configuracao");
			System.out.println("2 - Finalizar");
			System.out.println("+-------------------------------------------+");
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

	public void suaConfig(Scanner in) {
		int quantidadeMaxTigre = 0;
		int quantidadeMaxCoelho = 0;
		int quantidadeMaxArvore = 0;
		do {
			System.out.println("");
			System.out.println("+-------------------------------------------+");
			System.out.println("|            Suas Configuracoes             |");
			System.out.println("+-------------------------------------------+");
			System.out.println("Qual o tamanho do mapa:");
			System.out.println("1 - 10x10");
			System.out.println("2 - 12x12");
			System.out.println("3 - 16x16");
			System.out.println("4 - 21x21");
			System.out.print("Digite aqui: ");
			control = in.nextInt();
			if (control == 1) {
				valorProp = 10;
				quantidadeMaxTigre = 5;
				quantidadeMaxCoelho = 14;
				quantidadeMaxArvore = 18;
				//Veado = 10;
			} else if (control == 2) {
				valorProp = 12;
				quantidadeMaxTigre = 7;
				quantidadeMaxCoelho = 20;
				quantidadeMaxArvore = 25;
				//Veado = 13;
			} else if (control == 3) {
				valorProp = 16;
				quantidadeMaxTigre = 10;
				quantidadeMaxCoelho = 30;
				quantidadeMaxArvore = 38;
				//Veado = 20;
			} else if (control == 4) {
				valorProp = 21;
				quantidadeMaxTigre = 18;
				quantidadeMaxCoelho = 50;
				quantidadeMaxArvore = 60;
				//Veado = 38;
			}
		} while (control != 1 && control != 2 && control != 3 && control != 4);
		do {
			System.out.printf("Qual a quantidade de tigre(s)? - (MAX de %d): ", quantidadeMaxTigre);
			quantidadeTigre = in.nextInt();
		} while (quantidadeTigre > quantidadeMaxTigre);
		do {
			System.out.printf("Qual a quantidade de coelho(s)? - (MAX de %d): ", quantidadeMaxCoelho);
			quantidadeCoelho = in.nextInt();
		} while (quantidadeCoelho > quantidadeMaxCoelho);
		do {
			System.out.printf("Qual a quantidade de arvore(s)(MAXIMO de %d): ", quantidadeMaxArvore);
			quantidadeArvore = in.nextInt();
		} while (quantidadeArvore > quantidadeMaxArvore);
		System.out.println("+-------------------------------------------+");
		System.out.println("");
		//do {
		//	System.out.printf("Qual a quantidade de veado(s)(MAXIMO de %d): ", amountMaxDeer);
		//	amountDeer = in.nextInt();
		//} while (amountDeer > amountMaxDeer);
	}

}


