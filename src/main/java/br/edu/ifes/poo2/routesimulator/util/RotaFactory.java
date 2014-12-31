package br.edu.ifes.poo2.routesimulator.util;

import java.util.List;

import br.edu.ifes.poo2.routesimulator.cdp.Porto;
import br.edu.ifes.poo2.routesimulator.cdp.Rota;
import br.edu.ifes.poo2.routesimulator.cgd.ConfiguracaoDeRota;

public interface RotaFactory {

	public Rota fabricarRota(Porto portoorigem, Porto portodestino, int milhas, int tiporota, int restricaoderota);	
	public List<Rota> fabricarRotas(List<Porto> listadeportos, List<ConfiguracaoDeRota> listaconfrotas);		
}
