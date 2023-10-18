package br.uninassau.floresta;

import java.util.Random;

public class Planta {
	Random random = new Random();
	
	//Atributos da planta
	public int clicoVida, posix, posiy, vida;
	public String simbolo, nome;
	
	//Construtor da classe Planta
	public Planta(String nome, int vida, String simbolo, int tamanhoTerreno){
		this.nome = nome;
		this.clicoVida = 0;
		this.vida = vida;
		this.simbolo = simbolo;
		this.posix = random.nextInt(tamanhoTerreno);
		this.posiy = random.nextInt(tamanhoTerreno);
	}
	//Getter para obter informação das posições X e Y
	public int getposix() {
		return posix;
	}
	public int getposiy() {
		return posiy;
	}
}