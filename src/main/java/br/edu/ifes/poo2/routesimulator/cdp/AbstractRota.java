package br.edu.ifes.poo2.routesimulator.cdp;

import br.edu.ifes.poo2.routesimulator.cgd.TipoNavio;
import br.edu.ifes.poo2.routesimulator.cgd.TipoRota;

public abstract class AbstractRota implements Rota {

	protected int milhas;
	protected double te;
	protected Porto portoorigem;
	protected Porto portodestino;
	protected TipoNavio restricaoderota;
	protected TipoRota tiporota;

	@Override
	public int getMilhas() {
		return milhas;
	}
	
	public void setMilhas(int milhas) {
		this.milhas = milhas;
	}
	
	@Override
	public double getTe() {
		return te;
	}
	
	public void setTe(double te) {
		this.te = te;
	}
	
	@Override
	public Porto getPortoOrigem() {
		return portoorigem;
	}

	@Override
	public void setPortoOrigem(Porto portoorigem) {
		this.portoorigem = portoorigem;
	}

	@Override	
	public Porto getPortoDestino() {
		return portodestino;
	}

	@Override
	public void setPortoDestino(Porto portodestino) {
		this.portodestino = portodestino;
	}
	
	@Override
	public TipoNavio getRestricaoDeRota() {
		return this.restricaoderota;
	}

	public void setRestricaoDeRota(TipoNavio restricaoderota) {
		this.restricaoderota = restricaoderota;
	}
	
	@Override
	public TipoRota getTipoDeRota() {
		return tiporota;
	}

	public void setTipoRota(TipoRota tiporota) {
		this.tiporota = tiporota;
	}
	
	public boolean verificaSeRotaEstaPermitidaParaNavio(Navio navio, Rota rota){
		
		if(navio.getTipoNavio() == rota.getRestricaoDeRota()){
			return true;
		}
		else{
			return false;
		}		
	}
	
}
