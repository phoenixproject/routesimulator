package br.edu.ifes.poo2.routesimulator.cci;

import java.util.List;

import br.edu.ifes.poo2.routesimulator.cdp.Navio;
import br.edu.ifes.poo2.routesimulator.cdp.Porto;
import br.edu.ifes.poo2.routesimulator.cih.Tela;
import br.edu.ifes.poo2.routesimulator.cih.TelaResultado;

public class ControladorDeSimulacao implements Controlador {

	Tela tela = new TelaResultado();
	
	@Override
	public void exibeMensagem(Navio n) {
		tela.exibeMensagem(n);		
	}

	@Override
	public void exibeResultado(List<Porto> listadeportos) {
		tela.exibeResultado(listadeportos);		
	}

}
