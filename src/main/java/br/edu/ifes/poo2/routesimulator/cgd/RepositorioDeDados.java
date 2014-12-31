package br.edu.ifes.poo2.routesimulator.cgd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeDados implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	public static File leArquivoWindows(){
		
		//Define o tipo de arquivo que deverá ser lido
		File arquivo = new File("c:\\temp\\dado.txt");
		
		return arquivo;		
	}
	
	public static File leArquivoWindows(String nomearquivo){
		
		//Define o tipo de arquivo que deverá ser lido
		File arquivo = new File(nomearquivo);
		
		return arquivo;		
	}	
		
	@SuppressWarnings({"finally" })
	public static PortosRotasDestinos obterPortosRotasDestinos(File arquivo){

		//Declara um objeto do tipo PortosRotasDestinos
		PortosRotasDestinos prd = new PortosRotasDestinos();
		
		try{
			
			//Construtor que recebe o objeto do tipo arquivo
			FileReader fr = new FileReader(arquivo);
			 
			//Inicia um novo buffer para leitura do arquivo
			BufferedReader br = new BufferedReader(fr);			
			
			//Lê a primeira linha
			String linha = br.readLine();
			
			//Declara um arraylist para receber o resultado da linhas
			List<Integer> listainteiro = new ArrayList<Integer>();
			
			br.close();
			fr.close();
			
			//Recebe o resultado da linha em forma de inteiro
			listainteiro =  formataStringParaArrayDeInteiro(linha);
			
			//Armazena os valores da primeira da linha na variável prd
			prd.setQuantidadeportos(listainteiro.get(0));
			prd.setQuantidaderotas(listainteiro.get(1));
			prd.setQuantidadedestinos(listainteiro.get(2));
			
		} catch(FileNotFoundException e){
			System.err.println("Arquivo não existe");
		}
		finally{
			//Retorna as informações de PortosDestinosRotas
			return prd;					
		}
	}
	
	@SuppressWarnings({ "resource", "finally" })
	public static List<PortoDestino> obterArrayDePortoEDestinos(File arquivo){
		
		//double tempopedido = 0.0;
		List<PortoDestino> listaportodestino = new ArrayList<PortoDestino>();
		
		try{			
			//Declara um arraylist para receber o resultado da linhas
			List<Integer> listainteiro = new ArrayList<Integer>();
			
			//Construtor que recebe o objeto do tipo arquivo
			FileReader fr = new FileReader(arquivo);
			 
			//Inicia um novo buffer para leitura do arquivo
			BufferedReader br = new BufferedReader(fr);
			
			//Pula a primeira linha do arquivo que contém a identificação Portos, Rotas e Destinos			
			br.readLine();
			
			while (br.ready()) {
				
				//Declara uma string para receber a linha atual do arquivo
				String linha = br.readLine();
				
				//Declara um objeto PortoDestino para receber o dado atual do arquivo
				PortoDestino pd = new PortoDestino();
				
				//Recebe em uma lista de inteiro o valor da linha atual
				listainteiro =  formataStringParaArrayDeInteiro(linha);
				
				//Verifica se a lista de inteiro tem dois elementos(que caracteriza PortoDestino)
				if(listainteiro.size() == 2){
					
					//Adiciona os valores da lista ao objeto PortoDestino
					pd.setIdentificacaoporto(listainteiro.get(0));
					pd.setQuantidadedestinosdoporto(listainteiro.get(1));
					
					//Adiciona o objeto PortoDestino à lista de retorno
					listaportodestino.add(pd);					
				}
			}
			
		}  catch(FileNotFoundException e){
				System.err.println("Arquivo não existe");
		}
		finally{
			//Retorna as informações de todos os Portos e Destinos
			return listaportodestino;					
		}
	}
	
	@SuppressWarnings({ "resource", "finally" })
	public static List<ConfiguracaoDeRota> obterArrayDeConfiguracaoDeRotas(File arquivo){
		
		//double tempopedido = 0.0;
		List<ConfiguracaoDeRota> listaconfiguracaorota = new ArrayList<ConfiguracaoDeRota>();
		
		try{			
			//Declara um arraylist para receber o resultado da linhas
			List<Integer> listainteiro = new ArrayList<Integer>();
			
			//Construtor que recebe o objeto do tipo arquivo
			FileReader fr = new FileReader(arquivo);
			 
			//Inicia um novo buffer para leitura do arquivo
			BufferedReader br = new BufferedReader(fr);
			
			//Pula a primeira linha do arquivo que contém a identificação Portos, Rotas e Destinos			
			br.readLine();
			
			while (br.ready()) {
				
				//Declara uma string para receber a linha atual do arquivo
				String linha = br.readLine();
				
				//Declara um objeto PortoDestino para receber o dado atual do arquivo
				ConfiguracaoDeRota cr = new ConfiguracaoDeRota();
				
				//Recebe em uma lista de inteiro o valor da linha atual
				listainteiro =  formataStringParaArrayDeInteiro(linha);
				
				//Verifica se a lista de inteiro tem cinco elementos(que caracteriza Configuração de Rota)
				if(listainteiro.size() == 5){
					
					//Adiciona os valores da lista ao objeto Configuração de Rota
					cr.setPortoorigem(listainteiro.get(0));
					cr.setPortodestino(listainteiro.get(1));
					cr.setMilhasapercorrer(listainteiro.get(2));
					cr.setTipoderota(listainteiro.get(3));
					cr.setRestricaoderota(listainteiro.get(4));
					
					//Adiciona o objeto PortoDestino à lista de retorno
					listaconfiguracaorota.add(cr);					
				}
			}
			
		}  catch(FileNotFoundException e){
				System.err.println("Arquivo não existe");
		}
		finally{
			//Retorna as informações de todos os Portos e Destinos
			return listaconfiguracaorota;					
		}
	}
	
	public static List<Integer> formataStringParaArrayDeInteiro(String linha){
		
		List<Integer> listainteiro = new ArrayList<Integer>();
		String[] arraystring = linha.split(" ");
		
		for(String posicao: arraystring){
			
			listainteiro.add(Integer.parseInt(posicao));			
		}
		
		return listainteiro;
	}
	
}
