/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.routesimulator.util.test;

import br.edu.ifes.poo2.routesimulator.cdp.Porto;
import br.edu.ifes.poo2.routesimulator.cdp.PortoMaritimo;
import br.edu.ifes.poo2.routesimulator.cgd.ConfiguracaoDeRota;
import br.edu.ifes.poo2.routesimulator.cgd.PortoDestino;
import br.edu.ifes.poo2.routesimulator.util.FactoryPorto;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DiegoLindo
 */
public class FactoryPortoTest {
    
    FactoryPorto fp;
    
    @Before
    public void setUp() {
        fp = new FactoryPorto();
    }

    @Test
    public void testFabricarPorto() {
        Porto p = new PortoMaritimo();
        
        p.setIdentificacao(1);
        
       // Assert.assertEquals(p.getClass(), fp.fabricarPorto(1, null).getClass());
        
        Assert.assertSame(p.getClass(), fp.fabricarPorto(1, null).getClass());
    }

    @Test
    public void testFabricarPortos() {
        List<ConfiguracaoDeRota> lcr = new ArrayList<ConfiguracaoDeRota>();
        List<PortoDestino> lpt = new ArrayList<PortoDestino>();
        ConfiguracaoDeRota cr = new ConfiguracaoDeRota();
        PortoDestino p = new PortoDestino();
        
        cr.setTipoderota(2);
        cr.setRestricaoderota(1);
        lcr.add(cr);
        lpt.add(p);
        
        Assert.assertNotNull(fp.fabricarPortos(lcr, lpt));
        Assert.assertNotSame(0, fp.fabricarPortos(lcr, lpt).size());
        
    }
    
}
