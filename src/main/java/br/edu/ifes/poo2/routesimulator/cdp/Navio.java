package br.edu.ifes.poo2.routesimulator.cdp;

import br.edu.ifes.poo2.routesimulator.cgd.TipoNavio;

public interface Navio {
	
	public void setToneladas(int toneladas);
	public int getToneladas();
	public void setPassageiros(int passageiros);
	public void setTipoNavio(TipoNavio tiponavio);
	public void setRota(Rota rota);
	public Rota getRota();
	public double getVelocidadeMedia();
	public void setVelocidadeMedia(double velocidademedia);
	public TipoNavio getTipoNavio();
	public void calcularVelocidadeMediaNavio(Navio navio, Rota rota);
	public int getPassageiros();
	public void setMultas(int i);
	public int getMultas();
	public void setMilhasPercorridas(int i);
	public void setTotalMilhasPercorridas(int i);
	public int getTotalMilhasPercorridas();
	public int getMilhasPercorridas();	
	
}
