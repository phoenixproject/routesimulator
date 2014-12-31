package br.edu.ifes.poo2.routesimulator.cih;

import java.util.List;

import br.edu.ifes.poo2.routesimulator.cdp.Navio;
import br.edu.ifes.poo2.routesimulator.cdp.Porto;

public class TelaResultado implements Tela {

	@Override
	public void exibeMensagem(Navio n){											
		
		System.out.println("Navio: " + n.getTipoNavio());
		
		System.out.println("Passou por rota de " + n.getRota().getTipoDeRota());
		
		System.out.println("Número do porto de destino: " + n.getRota().getPortoDestino().getIdentificacao());
		
		System.out.println("O número de passageiros que chegou neste porto destino: " + n.getPassageiros());
														
		System.out.println("Toneladas de carga que chegaram: " + n.getToneladas() + " toneladas");
		
		System.out.println("Total multas aplicadas neste navio: " + n.getMultas());
		
		System.out.println("*************************************************************************");
		
		System.out.println();		
	}
	
	@Override
	public void exibeResultado(List<Porto> listadeportos){
		
		for(Porto p : listadeportos){
			
			if(p.getPortosDestinos() == null){
				
				int totaldepassageiros = 0;
				int toneladasdecarga = 0;
				int totalmultas = 0;
				
				System.out.println("Número do porto de destino: " + p.getIdentificacao());
				
				for(Navio n : p.getListaDeNavios()){
					
					totaldepassageiros = n.getPassageiros() + totaldepassageiros;
					toneladasdecarga = n.getToneladas() + toneladasdecarga;
					totalmultas = n.getMultas() + totalmultas;					
				}
				
				System.out.println("Total de passageiros : " + totaldepassageiros);
				System.out.println("Toneladas de carga : " + toneladasdecarga);
				System.out.println("Total de multas : " + totalmultas);
								
			}
			
		}		
		
	}
	
}
