package br.edu.ifes.poo2.routesimulator.cgt;

import java.util.List;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import br.edu.ifes.poo2.routesimulator.cci.Controlador;
import br.edu.ifes.poo2.routesimulator.cci.ControladorDeSimulacao;
import br.edu.ifes.poo2.routesimulator.cdp.Navio;
import br.edu.ifes.poo2.routesimulator.cdp.Porto;
import br.edu.ifes.poo2.routesimulator.cdp.Rota;
import br.edu.ifes.poo2.routesimulator.cgd.ConfiguracaoDeRota;
import br.edu.ifes.poo2.routesimulator.cgd.PortoDestino;
import br.edu.ifes.poo2.routesimulator.cgd.RepositorioDeDados;
import br.edu.ifes.poo2.routesimulator.util.FactoryNavio;
import br.edu.ifes.poo2.routesimulator.util.FactoryPorto;
import br.edu.ifes.poo2.routesimulator.util.FactoryRota;
import br.edu.ifes.poo2.routesimulator.util.NavioFactory;
import br.edu.ifes.poo2.routesimulator.util.PortoFactory;
import br.edu.ifes.poo2.routesimulator.util.Randomico;
import br.edu.ifes.poo2.routesimulator.util.RotaFactory;

public class GestorDeSimulacao extends AbstractGestor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public GestorDeSimulacao(String nomedoarquivo, int dias) throws Exception {
		
		//Inicializar o Repositório de Dados
		RepositorioDeDados repositoriodedados = new RepositorioDeDados();
		
		//Inicia um controlador de simulação
		Controlador controlador = new ControladorDeSimulacao();
				
		//Inicializa Randomico
		@SuppressWarnings("static-access")
		Randomico randomico = new Randomico().getInstance();
		
		//Lê o arquivo do caminho C:\temp\dado.txt
		@SuppressWarnings("static-access")
		File arquivo = repositoriodedados.leArquivoWindows(nomedoarquivo);
				
		//Obter as informações de portos, rotas e destinos do arquivo
		//PortosRotasDestinos portosrotasdestinos = repositoriodedados.obterPortosRotasDestinos(arquivo);		
		
		//Obter uma lista com todos os portos e seus respectivos destinos
		@SuppressWarnings("static-access")
		List<PortoDestino> listaportodestino = repositoriodedados.obterArrayDePortoEDestinos(arquivo);		
		
		//Obter uma lsita de configuração das frotas
		@SuppressWarnings("static-access")
		List<ConfiguracaoDeRota> listaconfrotas = repositoriodedados.obterArrayDeConfiguracaoDeRotas(arquivo);
		
		PortoFactory fabricadeportos = new FactoryPorto();		
		List<Porto> listadeportos = fabricadeportos.fabricarPortos(listaconfrotas, listaportodestino);
		
		RotaFactory fabricaderotas = new FactoryRota();
		List<Rota> listaderotas = fabricaderotas.fabricarRotas(listadeportos, listaconfrotas);
		
		NavioFactory fabricadenavios = new FactoryNavio();
		//Lista de navios fabricados para o porto de origem
		List<Navio> listadenavios = fabricadenavios.fabricarNavios();
		
		//Lista de navios que ficarão navegando nas rotas
		List<Navio> listadenavionavegantes = new ArrayList<Navio>();
		
		//Lista auxiliar de navios que serão removidos das rotas
		List<Navio> listadenavioaremover = new ArrayList<Navio>();
		 
						
		//Inicia o dia a partir do zero 
		int dia = 0;
		
		//dias = 100;
		
		//Enquanto da quantidade de dias não for igual a informada, prossegue o loop
		while(dia < dias){
		
			//*** 1 - Todos os navios que serão gerados irão para os portos de origem(zero) ***// 
			//Se for o primeiro dia(dia 0), todos os navios ficam atracados no porto zero(origem).
			if(dia == 0){
		
				//Percorre a lista de navios
				for(Navio n : listadenavios){
					
					//E adiciona determinado navio ao porto de origem(porto zero)
					listadeportos.get(0).getListaDeNavios().add(n);
				}
				
				//Limpa a lista de Navio
				listadenavios = new ArrayList<Navio>();								
			}			 
			else{
				//*** 2 - Navios Novos serão gerados aleatoriamente ***//	
				//A partir do dia 1, uma nova lista de navios será gerada
				listadenavios = fabricadenavios.fabricarNavios();
				
				//*** 3 - É verificado se existem navios nos portos(que não estejam na origem zero), nem no destino final ***//
				//Percorre a lista de portos
				for(Porto p : listadeportos){
					
					//Confere para que a busca não seja feita no porto de origem
					//Verifica se existe algum navio na lista de navios
					//Verifica se os portos de destino deste porto não são nulos(pois pode ser um porto final)
					if((p.getIdentificacao() != 0) && (p.getListaDeNavios().size() > 0) && (p.getPortosDestinos() !=  null)){ 
								
						//Percorre a lista de navios do porto
						for(Navio n : p.getListaDeNavios()){
							
							//Busca o próximo porto(aleatório) de destino
							int proximoportodestino = randomico.RandomInt(p.getPortosDestinos().get(0), p.getPortosDestinos().get(p.getPortosDestinos().size() - 1));
							
							//Percorre a lista de rotas
							for(Rota r : listaderotas){
								
								//Se o porto de origem da rota tiver a mesma identicacao do porto e o porto de destino tiver a mesma identidicacao do número aleatório, prossegue
								if(p.getIdentificacao() == r.getPortoOrigem().getIdentificacao() && r.getPortoDestino().getIdentificacao() == proximoportodestino){
									
									//Se o navio não tiver nenhuma rota preparada para ele, prossegue
									if(n.getRota() == null){
									
										//Calcula a velocidade média que o navio terá na rota
										n.calcularVelocidadeMediaNavio(n, r);
										
										//Se sim, adiciona a rota ao navio
										n.setRota(r);						
										
										//Coloca o navio na lista de navios navegantes
										listadenavionavegantes.add(n);
									}
								}								
							}
						}	
					}					
				}	
				
				//Limpa as listas de navio contidas nos portos(que não são de origem) e que não são destino(portos finais de trecho)
				for(Porto p : listadeportos){
					
					//Se o porto não é o de origem(zero) e nem é de destino(final)
					if(p.getIdentificacao() != 0 && p.getPortosDestinos() != null){
						
						//A lista de navios deste porto é removida(limpa)
						p.setListaDeNavios(new ArrayList<Navio>());
						
					}
					
				}
				
				//*** 4 - É verificada a lista dos navios que estão navegando em rotas ***//
				for(Navio n : listadenavionavegantes){
					
					//Se a lista dos navios navegantes tem algum registro, prossegue
					if(listadenavionavegantes.size() > 0){
				
						//Verifica se determinado navio está navegando em uma rota não apropriada para ele
						if(n.getRota().verificaSeRotaEstaPermitidaParaNavio(n, n.getRota()) == false){
							//Se sim, uma multa será aplicada
							n.setMultas(1 + n.getMultas());
						}
						
						//*** 5 - Se determinado navio já chegou em um porto, prossegue ***//
						//Verifica se todas as milhas percorridas da rota são maiores ou iguais as milhas da rota 
						if((getTotalHoraNavegacaoDia() * n.getVelocidadeMedia() + n.getMilhasPercorridas()) >= n.getRota().getMilhas()){
							
							//Se sim, o navio completa o total de milhas percorridas da rota e deverá ir para um porto de destino
							n.setMilhasPercorridas(n.getRota().getMilhas());				
							
							//Guarda o total de milhas percorridas por este navio por todo o trajeto
							n.setTotalMilhasPercorridas(n.getRota().getMilhas());
							
							//Se não existir nenhuma rota de destino disponível significa que chegou no seu destino final
							if(n.getRota().getPortoDestino().getPortosDestinos() == null){
								
								listadeportos.get(n.getRota().getPortoDestino().getIdentificacao()).getListaDeNavios().add(n);
								
								//System.out.println("Este navio( " + n.getTipoNavio() + ") chegou em seu destino final, porto " + n.getRota().getPortoDestino().getIdentificacao());			
							}
							else{
								//*** 6 - Identifica qual é o porto destino contido na rota ***//
								int portodestinodarota = n.getRota().getPortoDestino().getIdentificacao();
								
								//Percorre a lista de portos
								for(Porto p : listadeportos){
									
									//Verifica se a identificação do porto destino da rota é a mesma contida de algum porto da lista de portos
									if(portodestinodarota == p.getIdentificacao()){
										
										//Exibe outras mensagens ao chegar no porto de destino
										//controlador.exibeMensagem(n);
										
										//E remove a rota que o navio percorreu
										n.setRota(null);
										
										//Coloca as milhas percorridas na rota como zero(reinicializa)
										n.setMilhasPercorridas(0);
										
										//Se sim, adiciona o navio no porto encontrado
										p.getListaDeNavios().add(n);										
										
										//Coloca na lista de navios a remover
										listadenavioaremover.add(n);
									}
								}							
							}
						}
						//Senão, o todas as milhas percorridas da rota não foram suficiente para chegar no porto de destinos,
						//o navio fica na rota parado e só é incrementada as suas milhas percorridas
						else{
							n.setMilhasPercorridas((int) (getTotalHoraNavegacaoDia() * n.getVelocidadeMedia() + n.getMilhasPercorridas()));
							
							//Guarda o total de milhas percorridas por este navio por todo o trajeto
							n.setTotalMilhasPercorridas(n.getRota().getMilhas());
							
							//System.out.println("Navio " + n.getTipoNavio() + ", na rota de " + n.getRota().getTipoDeRota() + " ainda não chegou porto destino" + n.getRota().getPortoDestino().getIdentificacao());
							
							//System.out.println("*************************************************************************");
						}		
					}
				}
				
				//Remove os navios navegantes de rotas que foram colocados em portos de destino
				for(Navio n : listadenavioaremover){
					listadenavionavegantes.remove(n);
				}
				//Limpando os navios da lista de navios a remover
				listadenavioaremover = new ArrayList<Navio>();
				
				//*** 7 - Navios que estão no porto de origem, saem dele e vão para as rotas ***//
				for(Navio n : listadeportos.get(0).getListaDeNavios()){
					
					//Recebe aleatoriamente um número que informa o próximo porto 
					int proximodestino = randomico.RandomInt(listadeportos.get(0).getPortosDestinos().get(0), listadeportos.get(0).getPortosDestinos().get(listadeportos.get(0).getPortosDestinos().size() - 1));			
					
					//Percorre a lista de rotas
					for(Rota r : listaderotas){
												
						//Se a rota tiver o seu porto de origem como zero e seu porto de destino for igual ao destino aleatório, prossegue
						if(r.getPortoOrigem().getIdentificacao() == 0 && r.getPortoDestino().getIdentificacao() == proximodestino){
							
							//Se o navio não tiver nenhuma rota já preparada para ele, prossegue
							if(n.getRota() == null){
							
								//Calcula a velocidade média que o navio terá na rota
								n.calcularVelocidadeMediaNavio(n, r);	
								
								//O navio recebe esta rota
								n.setRota(r);	
								
								//Adiciona o navio na lista de navios navegantes
								listadenavionavegantes.add(n);
							}							
							
						}
						
					}					
				}				
				//Retira(limpa) todos os navios que estão no porto de origem
				listadeportos.get(0).setListaDeNavios(new ArrayList<Navio>());
				
				
				//*** 8 - Navios novos que acabaram de chegra, vão para o porto de origem, ***//
				//Percorre a lista de navios(novos)
				for(Navio n : listadenavios){
					
					//E adiciona determinado navio ao porto de origem(porto zero)
					listadeportos.get(0).getListaDeNavios().add(n);
				}
				
				//Limpa a lista de Navio(novos)
				listadenavios = new ArrayList<Navio>();				

			}
			
			//Incrementa o número de dias
			dia++;			
		}
		
		//Exibe o resultado dos portos de destino
		controlador.exibeResultado(listadeportos);
		
	}	

}


