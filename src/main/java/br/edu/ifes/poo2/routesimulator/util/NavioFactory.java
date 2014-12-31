package br.edu.ifes.poo2.routesimulator.util;

import java.util.List;

import br.edu.ifes.poo2.routesimulator.cdp.Navio;
import br.edu.ifes.poo2.routesimulator.cgd.TipoNavio;

public interface NavioFactory {

	public Navio fabricarNavio(TipoNavio tiponavio) throws Exception;  
	public List<Navio> fabricarNavios() throws Exception;
	
}
