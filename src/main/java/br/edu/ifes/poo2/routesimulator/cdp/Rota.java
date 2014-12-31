package br.edu.ifes.poo2.routesimulator.cdp;

import br.edu.ifes.poo2.routesimulator.cgd.TipoNavio;
import br.edu.ifes.poo2.routesimulator.cgd.TipoRota;

public interface Rota {
	
	public void setPortoDestino(Porto portodestino);
	public void setPortoOrigem(Porto portoorigem);
	public Porto getPortoDestino();
	public Porto getPortoOrigem();	
	public TipoNavio getRestricaoDeRota();
	public TipoRota getTipoDeRota();
	public double getTe();
	public boolean verificaSeRotaEstaPermitidaParaNavio(Navio navio, Rota rota);
	public int getMilhas();
}
