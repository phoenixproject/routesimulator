package br.edu.ifes.poo2.routesimulator.util;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifes.poo2.routesimulator.cdp.AbstractRota;
import br.edu.ifes.poo2.routesimulator.cdp.AguaLitoranea;
import br.edu.ifes.poo2.routesimulator.cdp.AguaProfunda;
import br.edu.ifes.poo2.routesimulator.cdp.AguaTranscontinental;
import br.edu.ifes.poo2.routesimulator.cdp.Porto;
import br.edu.ifes.poo2.routesimulator.cdp.PortoMaritimo;
import br.edu.ifes.poo2.routesimulator.cdp.Rota;
import br.edu.ifes.poo2.routesimulator.cgd.ConfiguracaoDeRota;
import br.edu.ifes.poo2.routesimulator.cgd.TipoNavio;
import br.edu.ifes.poo2.routesimulator.cgd.TipoRota;

public class FactoryRota extends AbstractFactoryRota {

	@Override
	public Rota fabricarRota(Porto portoorigem, Porto portodestino, int milhas, int tiporota, int restricaoderota) {
		
		AbstractRota rota = null;
		
		switch(tiporota){
		
			case 1:
				rota = new AguaProfunda();
				rota.setTipoRota(TipoRota.Profunda);
				break;
			case 2:
				rota = new AguaLitoranea();
				rota.setTipoRota(TipoRota.Litoranea);
				break;
			case 3:
				rota = new AguaTranscontinental();	
				rota.setTipoRota(TipoRota.Transcontinental);
				break;
			default:
				break;			
		}
		
		switch(restricaoderota){
		
			case 1:
				rota.setRestricaoDeRota(TipoNavio.Cruzeiro);				
				break;
			case 2:
				rota.setRestricaoDeRota(TipoNavio.Escuna);				
				break;
			case 3:
				rota.setRestricaoDeRota(TipoNavio.CargaGeral);				
				break;
			case 4:
				rota.setRestricaoDeRota(TipoNavio.Graneleiro);				
				break;			
			default:
				break;			
		}	
		
		rota.setPortoOrigem(portoorigem);
		rota.setPortoDestino(portodestino);
		rota.setMilhas(milhas);
								
		return rota;
	}
	
	@Override
	public List<Rota> fabricarRotas(List<Porto> listadeportos, List<ConfiguracaoDeRota> listaconfrotas) {

		List<Rota> listaderotas = new ArrayList<Rota>();
				
		Porto portoorigem = new PortoMaritimo();
		Porto portodestino = new PortoMaritimo();
				
		for(ConfiguracaoDeRota cr : listaconfrotas){
			
			portoorigem = portoorigem.retornarRegistroDeUmaListaDePortos(listadeportos, cr.getPortoorigem());
			portodestino = portodestino.retornarRegistroDeUmaListaDePortos(listadeportos, cr.getPortodestino());
			
			listaderotas.add(fabricarRota(portoorigem, portodestino, cr.getMilhasapercorrer(), cr.getTipoderota(), cr.getRestricaoderota()));
			
			portoorigem = new PortoMaritimo();
			portodestino = new PortoMaritimo();
		}		
		
		return listaderotas;
		
	}
					
}
