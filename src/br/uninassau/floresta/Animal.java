package br.uninassau.floresta;

import java.util.Random;
import br.uninassau.util.Terreno;

public class Animal {
	Random random = new Random();
	
	private int clicoVida, posix, posiy, vida;
	private String simbolo;
	private String nome;
	private boolean predador;
	
	//Construtor da criação do Animal
	public Animal(String nome, boolean predador, int vida, String simbolo, int tamanhoTerreno) {
		this.nome = nome;
		this.predador = predador;
		this.vida = vida;
		this.simbolo = simbolo;
		this.posix = random.nextInt(tamanhoTerreno);
		this.posiy = random.nextInt(tamanhoTerreno);
	}
	
	//Modulo da interação entre predadores e presas 
	public void comer(Animal predador, Animal presa, Terreno terreno) {
		if (predador.predador == true && presa.predador == false) {
			presa.vida--;
			if (presa.vida == 0) {
				terreno.imprimirTerreno();
				System.out.println(predador.nome + " comeu " + presa.nome);
				System.out.println(presa.nome + " sobreviveu por " + presa.getClicoVida() + " ciclos de vida");
				terreno.removerAnimal(presa);
				System.out.println("");
			}
		}
	}

	//Getter para obter informação
	public int getposix() {
		return posix;
	}
	public int getposiy() {
		return posiy;
	}
	public int getVida() {
		return vida;
	}
	public int getClicoVida() {
		return clicoVida;
	}
	public void setClicoVida(int clicoVida) {
		this.clicoVida = clicoVida;
	}		
	public String getSimbolo() {
		return simbolo;
	}
	public String getNome() {
		return nome;
	}
	public boolean getPredador() {
		return predador;
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
		//Verifica se esta no limite do mapa
		if (posX >= 0 && posX < terreno.getTamanho() && posY >= 0 && posY < terreno.getTamanho()) {
			//Se caso houver uma arvore no caminho, ele não irá colidir
			if(terreno.getTamanhoTerreno()[posX][posY].equals("#")){
				//Não faz nada, é uma posição com árvore
	        }
			//Caso contrario, irá se movimentar livremente
			else {
				terreno.removerAnimal(animal);
				terreno.moverAnimal(animal, posX, posY);
				posix = posX;
				posiy = posY;
			}
	    }
	}

}