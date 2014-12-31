package br.edu.ifes.poo2.routesimulator.cdp;

import java.util.List;


public interface Porto {

	public int getIdentificacao();
	
	public void setIdentificacao(int id);

	public Porto retornarRegistroDeUmaListaDePortos(List<Porto> listadeportos, int portoorigem);
	
	public List<Navio> getListaDeNavios();
	
	public void setListaDeNavios(List<Navio> navio);
	
	public List<Integer> getPortosDestinos();
	
}
