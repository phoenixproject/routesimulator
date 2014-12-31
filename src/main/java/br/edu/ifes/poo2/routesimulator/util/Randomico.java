package br.edu.ifes.poo2.routesimulator.util;

import java.math.BigInteger; 
import java.util.ArrayList; 
import java.util.List; 
 
/** 
 * 
 * @author paulo 
 */ 
public class Randomico { 
 
    private static Randomico randomico; 
    private final static int QTDNUMEROS = 100000;      
    private static int contador = 0;      
    private static List<BigInteger> numeros = new ArrayList<BigInteger>(); 
     
    public Randomico() { 
    
      fibonacciLoop(QTDNUMEROS); 
    } 
     
    //Funcao para gerar os numeros  
    private void fibonacciLoop(int quantidade){ 
         
      BigInteger fibo1 = new BigInteger("0"); 
      BigInteger fibo2 = new BigInteger("1"); 
      BigInteger fibonacci = new BigInteger("1"); 
         
      numeros.add(fibo1); 
      numeros.add(fibo2); 
         
        for(int i= 3; i<= quantidade; i++){ 
            fibonacci = fibo1.add(fibo2) ;  
            fibo1 = fibo2; 
            fibo2 = fibonacci; 
            numeros.add(fibonacci); 
        } 
    }    
     
    public synchronized static Randomico getInstance() 
    { 
      if (randomico == null) 
        randomico = new Randomico(); 
      return randomico; 
    } 
 
    public synchronized int RandomInt(int low, int high) throws Exception { 
 
        if (contador >= QTDNUMEROS) throw new Exception("Lascou"); 
       
        BigInteger numero = numeros.get(contador); 
        
        contador++; 
         
        Integer lowInt = low; 
             
        BigInteger lowX = new BigInteger(lowInt.toString()); 
        
        Integer valor = ((high - low) + 1); 
        
        BigInteger fator = new BigInteger(valor.toString()); 
        
        BigInteger resultado = (numero.mod(fator)).add(lowX); 
        
        return resultado.intValue(); 
   } 
    
} 