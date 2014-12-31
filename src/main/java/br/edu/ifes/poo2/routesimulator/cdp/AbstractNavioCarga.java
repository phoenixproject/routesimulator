package br.edu.ifes.poo2.routesimulator.cdp;

public abstract class AbstractNavioCarga extends AbstractNavio {

	protected int toneladas;

	@Override
	public int getToneladas() {
		return toneladas;
	}

	public void setToneladas(int toneladas) {
		this.toneladas = toneladas;
	}
	
}
