package br.edu.ifes.poo2.routesimulator.cci;

import java.util.List;

import br.edu.ifes.poo2.routesimulator.cdp.Navio;
import br.edu.ifes.poo2.routesimulator.cdp.Porto;

public interface Controlador {
	
	public void exibeMensagem(Navio n);
	public void exibeResultado(List<Porto> listadeportos);
}
