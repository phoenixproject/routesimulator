package br.edu.ifes.poo2.routesimulator.cdp;

import java.util.List;

public abstract class AbstractPorto implements Porto {
	
	private int identificacao;
	private List<Integer> portosdestinos;
	private List<Navio> listadenavios;

	@Override
	public int getIdentificacao() {
		return identificacao;
	}
	
	@Override
	public void setIdentificacao(int identificacao) {
		this.identificacao = identificacao;
	}
	
	@Override
	public List<Integer> getPortosDestinos() {
		return portosdestinos;
	}
	
	public void setPortosDestinos(List<Integer> portosdestinos) {
		this.portosdestinos = portosdestinos;
	}
	
	@Override
	public List<Navio> getListaDeNavios() {
		return listadenavios;
	}

	@Override
	public void setListaDeNavios(List<Navio> listadenavios) {
		this.listadenavios = listadenavios;
	}
	
	@Override
	public Object clone() {

		Object obj = null;
		
		try{
			obj = super.clone();
			
		} catch( CloneNotSupportedException e ){			
			System.out.println(e.getMessage());			
		}			
		
		return obj;		
	}	
	
	@Override
	public Porto retornarRegistroDeUmaListaDePortos(List<Porto> listadeportos, int idporto){
		
		Porto porto = new PortoMaritimo();
		
		try{
			for(Porto p : listadeportos){
				
				if(p.getIdentificacao() == idporto){
					porto = p;
				}			
			}
		}
		catch(Exception e){
			System.err.println("Registro não encontrado");
		}				
		
		return porto;
	}

}
