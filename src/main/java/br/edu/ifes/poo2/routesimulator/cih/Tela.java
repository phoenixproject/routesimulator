package br.edu.ifes.poo2.routesimulator.cih;

import java.util.List;

import br.edu.ifes.poo2.routesimulator.cdp.Navio;
import br.edu.ifes.poo2.routesimulator.cdp.Porto;

public interface Tela {

	public void exibeMensagem(Navio n);
	public void exibeResultado(List<Porto> listadeportos);
}
