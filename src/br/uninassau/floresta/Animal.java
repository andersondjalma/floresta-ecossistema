package br.uninassau.floresta;

import java.util.Random;
import br.uninassau.util.Terreno;
import br.uninassau.util.Configuracoes;

public class Animal {
	Random random = new Random();
	Configuracoes config = new Configuracoes();
	
	public int clicoVida, posix, posiy, vida;
	public String simbolo;
	String nome;
	boolean predador;
	
	//Construtor da criação do Animal
	public Animal(String nome, boolean predador, int vida, String simbolo) {
		this.nome = nome;
		this.predador = predador;
		this.vida = vida;
		this.simbolo = simbolo;
		this.posix = random.nextInt(10);
		this.posiy = random.nextInt(10);
	}
	
	
	public void comer(Animal predador, Animal presa, Terreno terreno) {
		if (predador.predador == true && presa.predador == false) {
			presa.vida--;
			if (presa.vida == 0) {
				terreno.imprimirTerreno();
				System.out.println(predador.nome + " comeu " + presa.nome);
				System.out.println(presa.nome + " sobreviveu por " + presa.clicoVida + " ciclos de vida");
				terreno.removerAnimal(presa);
				System.out.println("");
			}
		}
	}
	
	//Get das posições X e Y
	public int getposix() {
		return posix;
	}
	public int getposiy() {
		return posiy;
	}
	
	//Movimento dos Animais
	public void mover(Terreno terreno, Animal animal) {
		int direcao = random.nextInt(4);
		int posX = getposix();
		int posY = getposiy();
		switch (direcao) {
			case 0: // Sul
				posX++;
				break;
			case 1: // Norte
				posX--;
				break;
			case 2: // Leste
				posY++;
				break;
			case 3: // Oeste
				posY--;
				break;
	}
		if (posX >= 0 && posX < terreno.getTamanho() && posY >= 0 && posY < terreno.getTamanho()) {
			terreno.removerAnimal(animal);
			terreno.moverAnimal(animal, posX, posY);
			posix = posX;
			posiy = posY;
		}
		
	}	
}
	

