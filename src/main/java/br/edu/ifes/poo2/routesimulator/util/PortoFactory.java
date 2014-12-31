package br.edu.ifes.poo2.routesimulator.util;

import java.util.List;

import br.edu.ifes.poo2.routesimulator.cdp.Porto;
import br.edu.ifes.poo2.routesimulator.cgd.ConfiguracaoDeRota;
import br.edu.ifes.poo2.routesimulator.cgd.PortoDestino;

public interface PortoFactory {
	
	public Porto fabricarPorto(int id, List<Integer> portosdestinos);	
	public List<Porto> fabricarPortos(List<ConfiguracaoDeRota> listaconfrota, List<PortoDestino> listaportodestino);

}
