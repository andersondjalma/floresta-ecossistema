package br.uninassau.floresta;

import java.util.Scanner;
import br.uninassau.animais.Coelho;
import br.uninassau.animais.Tigre;
import br.uninassau.plantas.Arvore;
import br.uninassau.util.Configuracoes;
import br.uninassau.util.Terreno;

public class SimuladorEcossistema {
	public static void main(String[] args) {

        //Inicia o menu de Configurações
        Scanner in = new Scanner(System.in);
        Configuracoes config = new Configuracoes(in);
        in.close();

        //Recebe o tamanho do mapa da configuração e coloca no construtor do terreno
        Terreno terreno = new Terreno(config.getTamanhoMapa());

        //Adicionando os objetos
        Coelho[] coelhos = new Coelho[config.getquantidadeCoelho()];
        for (int i = 0; i < coelhos.length; i++) {
            String coelhoNome = "Coelho" + (i + 1);
            coelhos[i] = new Coelho(coelhoNome, false, 1, "C", config.getTamanhoMapa());
            terreno.adicionarAnimal(coelhos[i]);
        }
        Tigre[] tigres = new Tigre[config.getquantidadeTigre()];
        for (int i = 0; i < tigres.length; i++) {
        	String tigreNome = "Tigre" + (i + 1);
        	tigres[i] = new Tigre(tigreNome, true, 5, "T", config.getTamanhoMapa());
        	terreno.adicionarAnimal(tigres[i]);
        } 
        Arvore[] arvores = new Arvore[config.getquantidadeArvore()];
        for (int i = 0; i < arvores.length; i++) {
            String arvoreNome = "Tigre" + (i + 1);
            arvores[i] = new Arvore(arvoreNome, 1, "#", config.getTamanhoMapa());
            terreno.adicionarPlanta(arvores[i]);
        }
        
        //Loop do Ecossistema
        while (true) {
        	//Inicia o terreno
        	terreno.imprimirTerreno();
        	System.out.println("");
        	
        	//Adiciona aos objetos clico de vida e movimento
        	for (Arvore arvore : arvores) {
        		arvore.clicoVida++;
        	}
            for (Animal coelho : coelhos) {
            	if(coelho.vida > 0) {
            		coelho.mover(terreno, coelho);
            		coelho.clicoVida++;
            	}
            } 
            for (Animal tigre : tigres) {
            	if(tigre.vida > 0) {
            		tigre.mover(terreno, tigre);
            		tigre.clicoVida++;
            	}
            }
            
            //Reconhece quando um tigre está no mesmo local que um coelho, e se alimenta, matando o coelho
            for(Animal coelho : coelhos) {
            	for(Animal tigre : tigres) {
            		if (tigre.getposix() == coelho.getposix() && tigre.getposiy() == coelho.getposiy()) {
            			tigre.comer(tigre, coelho, terreno);
            			if (coelho.vida == 0) {
            				break;
            			}
            		}
            	}
            }
            
            //Verifica se todos os Coelhos foram mortos, assim terminando o programa
            boolean todosMortos = true;
            for (Coelho coelho : coelhos) {
                if (coelho.vida > 0) {
                    todosMortos = false;
                    break;
                }
            }
            if (todosMortos) {
            	break;
            }
            
            // Delay na atualização do Terreno
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
}