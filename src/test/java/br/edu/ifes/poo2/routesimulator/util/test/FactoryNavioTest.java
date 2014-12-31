/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.routesimulator.util.test;

import br.edu.ifes.poo2.routesimulator.cdp.Cruzeiro;
import br.edu.ifes.poo2.routesimulator.cdp.Navio;
import br.edu.ifes.poo2.routesimulator.cgd.TipoNavio;
import br.edu.ifes.poo2.routesimulator.util.FactoryNavio;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author DiegoLindo
 */
@SuppressWarnings("deprecation")
public class FactoryNavioTest {
    
    
    FactoryNavio fn;
    @Before
    public void setUp() {
        fn = new FactoryNavio();
    }

    @Test
    public void testFabricarNavio() throws Exception {
        Navio c = new Cruzeiro();
        
        Assert.assertEquals(c.getClass(),fn.fabricarNavio(TipoNavio.Cruzeiro).getClass() );
    }

    @Test
    public void testFabricarNavios_0args() throws Exception {
        List<Navio> testelistanavios = new ArrayList<Navio>();
        
        testelistanavios = fn.fabricarNavios();
        
        Assert.assertNotNull(testelistanavios);
        Assert.assertNotSame(0, testelistanavios.size());
    }

    
}
