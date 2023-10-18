package br.uninassau.util;

import java.util.Random;

import br.uninassau.floresta.Animal;
import br.uninassau.floresta.Planta;

public class Terreno {
	public String[][] tamanhoTerreno; //Matriz que representa o Terreno 
	int valorProp; //Aqui vamos armazenar a proporção da Matriz
	Random random = new Random();
	
	//Construtor para saber o tamanho do terreno
	public Terreno(int tamanho) { 
			this.valorProp = tamanho;
			this.tamanhoTerreno = criarTerreno();
		}
	
	//Get para o tamanho do terreno
	public int getTamanho() {
		return valorProp;
	}
		
	//Método para criar o terreno com o tamanho correto
	public String[][] criarTerreno() {
			String[][] tamanhoTerreno = new String[valorProp][valorProp];
		    for (int i = 0; i < valorProp; i++) {
		        for (int j = 0; j < valorProp; j++) {
		            tamanhoTerreno[i][j] = ".";
		        }
		    }
		    return tamanhoTerreno;
		}
	
	//Método para imprimir o conteúdo do Terreno
		public void imprimirTerreno() {
			for (int i = 0; i < valorProp; i++) {
				for (int j = 0; j < valorProp; j++) {
					System.out.print(tamanhoTerreno[i][j] + " ");
				}
				System.out.println("|");
			}
		}
		
	//Adicionar um Animal
		public void adicionarAnimal(Animal animal) {
				tamanhoTerreno[animal.getposix()][animal.getposiy()] = animal.simbolo;
		}
		
	//Adicionar uma planta
		public void adicionarPlanta(Planta planta) {
			tamanhoTerreno[planta.posix][planta.posiy] = planta.simbolo;
		}	
	//Mover o Animal
		public void moverAnimal(Animal animal, int posX, int posY) {
			tamanhoTerreno[posX][posY] = animal.simbolo;
		}
	//Remover animal
		public void removerAnimal(Animal animal) {
			tamanhoTerreno[animal.getposix()][animal.getposiy()] = ".";
		}	
}
