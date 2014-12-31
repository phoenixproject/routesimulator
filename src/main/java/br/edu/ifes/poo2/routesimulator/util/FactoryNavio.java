package br.edu.ifes.poo2.routesimulator.util;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifes.poo2.routesimulator.cdp.AbstractNavio;
import br.edu.ifes.poo2.routesimulator.cdp.CargaGeral;
import br.edu.ifes.poo2.routesimulator.cdp.Cruzeiro;
import br.edu.ifes.poo2.routesimulator.cdp.Escuna;
import br.edu.ifes.poo2.routesimulator.cdp.Graneleiro;
import br.edu.ifes.poo2.routesimulator.cdp.Navio;
import br.edu.ifes.poo2.routesimulator.cgd.TipoNavio;

public class FactoryNavio extends AbstractFactoryNavio {
	
	//Inicializa Randomico
	@SuppressWarnings("static-access")
	Randomico randomico = new Randomico().getInstance();

	@Override
	public Navio fabricarNavio(TipoNavio tiponavio) throws Exception {
		
		AbstractNavio navio = null;
		
		switch(tiponavio){
		
			case Cruzeiro: 
				navio = new Cruzeiro();
				navio.setPassageiros(randomico.RandomInt(0, 500));
				navio.setTipoNavio(tiponavio);
				navio.setMilhasPercorridas(0);
				break;
				
			case Escuna:
				navio = new Escuna();
				navio.setPassageiros(randomico.RandomInt(0, 20));
				navio.setTipoNavio(tiponavio);
				navio.setMilhasPercorridas(0);
				break;
				
			case CargaGeral: 
				navio = new CargaGeral();
				navio.setPassageiros(randomico.RandomInt(0, 12));
				navio.setToneladas(randomico.RandomInt(0, 150));
				navio.setTipoNavio(tiponavio);
				navio.setMilhasPercorridas(0);
				break;
				
			case Graneleiro:
				navio = new Graneleiro();
				navio.setPassageiros(randomico.RandomInt(0, 6));
				navio.setToneladas(randomico.RandomInt(0, 200));
				navio.setTipoNavio(tiponavio);
				navio.setMilhasPercorridas(0);
				break;
				
			default:
				break;
		}
		
		return navio;
		
	}

	@Override
	public List<Navio> fabricarNavios() throws Exception {
		
		List<Navio> listadenavios = new ArrayList<Navio>();
		
		int quantidadecruzeiro = randomico.RandomInt(0, 2);
		int quantidadeescuna = randomico.RandomInt(0, 5);
		int quantidadecargageral = randomico.RandomInt(0, 3);
		int quantidadegraneleiro = randomico.RandomInt(0, 2);
		
		for(int i = 0; i < quantidadecruzeiro; i++){
			listadenavios.add(fabricarNavio(TipoNavio.Cruzeiro));
		}
		
		for(int i = 0; i < quantidadeescuna; i++){
			listadenavios.add(fabricarNavio(TipoNavio.Escuna));
		}
				
		for(int i = 0; i < quantidadecargageral; i++){
			listadenavios.add(fabricarNavio(TipoNavio.CargaGeral));
		}
		
		for(int i = 0; i < quantidadegraneleiro; i++){
			listadenavios.add(fabricarNavio(TipoNavio.Graneleiro));
		}		
		
		return listadenavios;
	}	
}
