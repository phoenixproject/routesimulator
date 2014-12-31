/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.routesimulator.cgd.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifes.poo2.routesimulator.cgd.RepositorioDeDados;
import static org.junit.Assert.*;

/**
 *
 * @author DiegoLindo
 */
public class RepositorioDeDadosTest {
    RepositorioDeDados rdd;
    
    @Before
    public void setUp() {
        rdd = new RepositorioDeDados();
    }

  
    @Test
    public void testObterPortosRotasDestinos() {
        File arquivo = new File("dado.txt");
        Assert.assertNotNull(rdd.obterPortosRotasDestinos(arquivo.getParentFile()));
        Assert.assertNotSame(3,rdd.obterPortosRotasDestinos(arquivo.getParentFile()).getQuantidadedestinos());
        Assert.assertNotSame(3,rdd.obterPortosRotasDestinos(arquivo.getParentFile()).getQuantidadeportos());
        Assert.assertNotSame(3,rdd.obterPortosRotasDestinos(arquivo.getParentFile()).getQuantidaderotas());
    }

    @Test
    public void testObterArrayDePortoEDestinos() {
        File arquivo = new File("dado.txt");
        Assert.assertNotNull(rdd.obterArrayDePortoEDestinos(arquivo.getParentFile()));
    }

    @Test
    public void testObterArrayDeConfiguracaoDeRotas() {
        File arquivo = new File("dado.txt");
        Assert.assertNotNull(rdd.obterArrayDeConfiguracaoDeRotas(arquivo.getParentFile()));
    }

    @Test
    public void testFormataStringParaArrayDeInteiro() {
        List<Integer> li = new ArrayList<Integer>();
        
        li.add(1);
        li.add(2);
        li.add(3);
        Assert.assertNotNull(rdd.formataStringParaArrayDeInteiro("1 2 3"));
        Assert.assertEquals(rdd.formataStringParaArrayDeInteiro("1 2 3"), li);
        
    }
    
}
