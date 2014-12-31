package br.edu.ifes.poo2.routesimulator.cgd;

public class ConfiguracaoDeRota {

	private int portoorigem;
	private int portodestino;
	private int milhasapercorrer;
	private int tipoderota;
	private int restricaoderota;
	
	public int getPortoorigem() {
		return portoorigem;
	}
	
	public void setPortoorigem(int portoorigem) {
		this.portoorigem = portoorigem;
	}
	
	public int getPortodestino() {
		return portodestino;
	}
	
	public void setPortodestino(int portodestino) {
		this.portodestino = portodestino;
	}
	
	public int getMilhasapercorrer() {
		return milhasapercorrer;
	}
	
	public void setMilhasapercorrer(int milhasapercorrer) {
		this.milhasapercorrer = milhasapercorrer;
	}
	
	public int getTipoderota() {
		return tipoderota;
	}
	
	public void setTipoderota(int tipoderota) {
		this.tipoderota = tipoderota;
	}
	
	public int getRestricaoderota() {
		return restricaoderota;
	}

	public void setRestricaoderota(int restricaoderota) {
		this.restricaoderota = restricaoderota;
	}
	
}
