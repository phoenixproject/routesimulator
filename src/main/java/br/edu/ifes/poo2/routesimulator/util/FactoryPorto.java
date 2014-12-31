package br.edu.ifes.poo2.routesimulator.util;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifes.poo2.routesimulator.cdp.Navio;
import br.edu.ifes.poo2.routesimulator.cdp.Porto;
import br.edu.ifes.poo2.routesimulator.cdp.PortoMaritimo;
import br.edu.ifes.poo2.routesimulator.cgd.ConfiguracaoDeRota;
import br.edu.ifes.poo2.routesimulator.cgd.PortoDestino;

public class FactoryPorto extends AbstractFactoryPorto implements Cloneable {

	@Override
	public Porto fabricarPorto(int id, List<Integer> portosdestinos) {
		
		PortoMaritimo porto = new PortoMaritimo();
		
		porto.setIdentificacao(id);
		porto.setPortosDestinos(portosdestinos);
		porto.setListaDeNavios(new ArrayList<Navio>());
		
		return porto;
	}
	
	@Override
	public List<Porto> fabricarPortos(List<ConfiguracaoDeRota> listaconfrota, List<PortoDestino> listaportodestino) {
				
		//Declara uma lista de portos para retorno
		List<Porto> listadeportos = new ArrayList<Porto>();
				
		//Declara e inicializa a variável idporto para armazenar o id do porto que será criado 
		int idporto = 0;
		
		//Declara uma lista de portos de destinos que armazenará os ids dos portos de destino de cada porto
		List<Integer> listaportosdestinos = new ArrayList<Integer>();
		
		//Percorre a lista de portos e suas respecetivas quantidades de destino
		for(PortoDestino pd : listaportodestino){
			
			//Compara se a quantidade de destinos de determinado porto é maior do que zero
			if(pd.getQuantidadedestinosdoporto() > 0){				
				
				//Se for maior que zero, percorre a lista das configurações de rota para armazenar os destinos de determinado porto
				for(ConfiguracaoDeRota cr : listaconfrota){
					
					//Se determinado porto de origem tem o mesmo identificador de um porto de origem de determinada rota, prossegue
					if(cr.getPortoorigem() == pd.getIdentificacaoporto()){
						//Armazena o id do porto de origem
						idporto = pd.getIdentificacaoporto();
						//E acrescenta mais um porto de destino que será associado ao id do porto acima 
						listaportosdestinos.add(cr.getPortodestino());
					}					
				}
				//Armazena na lista de retorno de porto, determinado porto que foi criado com seus repectivos destinos
				listadeportos.add(fabricarPorto(idporto, listaportosdestinos));
				
				//Limpa a lista de portos e destinos
				listaportosdestinos = new ArrayList<Integer>();
				//listaportosdestinos.clear();
			}
			else{
				//Armazena o id do porto de origem
				idporto = pd.getIdentificacaoporto();
				
				//Armazena na lista de retorno de porto, determinado porto que foi criado e que não contem destino, por isso recebe null
				listadeportos.add(fabricarPorto(idporto, null));
				
				//Limpa a lista de portos e destinos
				listaportosdestinos = new ArrayList<Integer>();
			}
			
		}
		
		//Retorna a lista de portos com seus respectivos destinos
		return listadeportos;
	}	
}
