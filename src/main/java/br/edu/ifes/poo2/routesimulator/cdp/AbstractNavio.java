package br.edu.ifes.poo2.routesimulator.cdp;

import br.edu.ifes.poo2.routesimulator.cgd.TipoNavio;

public abstract class AbstractNavio implements Navio {

	protected int passageiros;	
	protected int multas;
	protected int milhaspercorridas;
	protected int totalmilhaspercorridas;
	protected double velocidademedia;
	protected Rota rota;
	protected TipoNavio tiponavio;

	@Override
	public int getPassageiros() {
		return passageiros;
	}
	
	@Override
	public void setPassageiros(int passageiros) {
		this.passageiros = passageiros;
	}
	
	@Override
	public int getMultas() {
		return multas;
	}
	
	@Override
	public void setMultas(int multas) {
		this.multas = multas;
	}	
	
	@Override
	public int getMilhasPercorridas() {
		return milhaspercorridas;
	}

	@Override
	public void setMilhasPercorridas(int milhaspercorridas) {
		this.milhaspercorridas = milhaspercorridas;
	}
	
	@Override
	public int getTotalMilhasPercorridas() {
		return totalmilhaspercorridas;
	}

	@Override
	public void setTotalMilhasPercorridas(int totalmilhaspercorridas) {
		this.totalmilhaspercorridas = totalmilhaspercorridas;
	}		
		
	@Override
	public double getVelocidadeMedia() {
		return velocidademedia;
	}

	@Override
	public void setVelocidadeMedia(double velocidademedia) {
		this.velocidademedia = velocidademedia;
	}	
	
	@Override
	public Rota getRota() {
		return rota;
	}

	@Override
	public void setRota(Rota rota) {
		this.rota = rota;
	}	
	
	@Override
	public TipoNavio getTipoNavio() {
		return tiponavio;
	}

	@Override
	public void setTipoNavio(TipoNavio tiponavio) {
		this.tiponavio = tiponavio;
	}	
		
	@Override
	public void calcularVelocidadeMediaNavio(Navio navio, Rota rota){
		
		switch(navio.getTipoNavio()){
		
		case Cruzeiro:			
			navio.setVelocidadeMedia((36 * rota.getTe()) - (0.2 * navio.getPassageiros()));
			break;
			
		case Escuna:			
			navio.setVelocidadeMedia((22 * rota.getTe() - (0.6 * navio.getPassageiros())));
			break;
			
		case CargaGeral:			
			navio.setVelocidadeMedia((22 * rota.getTe() - 0.01 * navio.getPassageiros()) - (0.4 * navio.getToneladas()));
			break;
			
		case Graneleiro:			
			navio.setVelocidadeMedia((20 * rota.getTe() - 0.01 * navio.getPassageiros()) - (0.3 * navio.getToneladas()));
			break;			
		}
		
	}
	
		
}
