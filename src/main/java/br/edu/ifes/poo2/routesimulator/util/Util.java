package br.edu.ifes.poo2.routesimulator.util;

import java.util.Random;

public class Util {
	
	public static int geraDadoInteiroAleatorio(){
		
		//Declara um objeto do tipo Random
		Random gerador = new Random();
		int numero = 0;
		
		//Gera numeros aleatorios entre 0 e 30
		while(numero < 1){
			numero = gerador.nextInt(30);
		}
		return numero;
	}
	
	public static int geraDadoInteiroAleatorioEntreIntevalo(int primeiro, int segundo){
		
		if(primeiro <= segundo){
			//Declara um objeto do tipo Random
			Random gerador = new Random();
			int numero = -1;
			
			//Gera numeros aleatorios entre o primeiro(ex: 10) e o segundo(ex: 70)
			while(numero < primeiro){
				numero = gerador.nextInt(segundo);
			}
			
			return numero;			
		}
		else{
			System.err.println("Segundo número menor que primeiro");
			return - 1;
		}		
	}
}
