/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.routesimulator.cdp.test;

import br.edu.ifes.poo2.routesimulator.cdp.AguaLitoranea;
import br.edu.ifes.poo2.routesimulator.cdp.Cruzeiro;
import br.edu.ifes.poo2.routesimulator.cdp.Navio;
import br.edu.ifes.poo2.routesimulator.cdp.Rota;
import br.edu.ifes.poo2.routesimulator.cgd.TipoNavio;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author DiegoLindo
 */
@SuppressWarnings("deprecation")
public class AbstractNavioTest {
    
    Navio n;
    Rota r;
    
    @Before
    public void setUp() {
        n = new Cruzeiro();
        r = new AguaLitoranea();
        n.setPassageiros(20);
        n.setVelocidadeMedia(140);
        n.setTipoNavio(TipoNavio.Cruzeiro);
    }

    
    @SuppressWarnings("deprecation")
	@Test
    public void testCalcularVelocidadeMediaNavio() {
        Navio testenavio = new Cruzeiro();
        Rota testerota = new AguaLitoranea();
        
        testenavio.setTipoNavio(TipoNavio.Cruzeiro);
        testenavio.setPassageiros(20);
        testenavio.calcularVelocidadeMediaNavio(testenavio, testerota);
        
        Assert.assertEquals(n.getVelocidadeMedia(), testenavio.getVelocidadeMedia(), 0);
        
    }

       
}
