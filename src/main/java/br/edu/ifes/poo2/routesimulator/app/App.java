package br.edu.ifes.poo2.routesimulator.app;

import br.edu.ifes.poo2.routesimulator.cgt.GestorDeSimulacao;

public class App {

	public static void main(String[] args) throws Exception {
		
     	new GestorDeSimulacao(args[0], Integer.parseInt(args[1]));
	}
}