package br.edu.ifes.poo2.routesimulator.cgt;

public class AbstractGestor implements Gestor {
	
	private int totalhoranavegacaodia;
	
	public AbstractGestor(){
		this.totalhoranavegacaodia = 12;
	}
		
	@Override
	public int getTotalHoraNavegacaoDia() {
		return totalhoranavegacaodia;
	}
	
	public void setTotalHoraNavegacaoDia(int totalhoranavegacaodia) {
		this.totalhoranavegacaodia = totalhoranavegacaodia;
	}
	
}
