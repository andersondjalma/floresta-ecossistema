package br.uninassau.floresta;

import java.util.Random;

public class Planta {
	Random random = new Random();
	
	//Atributos da planta
	private int clicoVida; 
	private int vida;
	private int posix;
	private int posiy;
	private String simbolo;
	private String nome;
	
	//Construtor da classe Planta
	public Planta(String nome, int vida, String simbolo, int tamanhoTerreno){
		this.nome = nome;
		this.setClicoVida(0);
		this.vida = vida;
		this.simbolo = simbolo;
		this.posix = random.nextInt(tamanhoTerreno);
		this.posiy = random.nextInt(tamanhoTerreno);
	}
	//Getter para obter informações
	public int getposix() {
		return posix;
	}
	public int getposiy() {
		return posiy;
	}
	public String getNome() {
		return nome;
	}
	public String getSimbolo() {
		return simbolo;
	}
	public int getClicoVida() {
		return clicoVida;
	}
	public void setClicoVida(int clicoVida) {
		this.clicoVida = clicoVida;
	}
	public int getvida() {
		return vida;
	}
	
}