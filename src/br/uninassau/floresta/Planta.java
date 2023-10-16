package br.uninassau.floresta;

import java.util.Random;

public class Planta {
	Random random = new Random();
	
	public int clicoVida, posix, posiy, vida;
	public String simbolo, nome;
	
	public Planta(String nome, int vida, String simbolo){
		this.nome = nome;
		this.clicoVida = 0;
		this.vida = vida;
		this.simbolo = simbolo;
		this.posix = random.nextInt(10);
		this.posiy = random.nextInt(10);
	}
}
