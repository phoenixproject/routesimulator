package br.edu.ifes.poo2.routesimulator.util.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.ifes.poo2.routesimulator.cdp.AguaLitoranea;
import br.edu.ifes.poo2.routesimulator.cdp.Porto;
import br.edu.ifes.poo2.routesimulator.cdp.PortoMaritimo;
import br.edu.ifes.poo2.routesimulator.cdp.Rota;
import br.edu.ifes.poo2.routesimulator.cgd.ConfiguracaoDeRota;
import br.edu.ifes.poo2.routesimulator.util.FactoryRota;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;

public class FactoryRotaTest {

	FactoryRota fr;
	
	@Before
	public void setUp() throws Exception {
            fr = new FactoryRota();		
	}

	@Test
	public void testFabricarRota() {

            Rota rota = new AguaLitoranea();

            Assert.assertEquals(rota.getClass(), fr.fabricarRota(new PortoMaritimo(), new PortoMaritimo(), 333, 2, 1).getClass());
	}

	@Test
	public void testFabricarRotas() {
            List<ConfiguracaoDeRota> lcr = new ArrayList<ConfiguracaoDeRota>();
            List<Porto> lpr = new ArrayList<Porto>();
            List<Rota> lrr = new ArrayList<Rota>(),lrrr = new  ArrayList<Rota>();
            ConfiguracaoDeRota cr = new ConfiguracaoDeRota();
            Porto pr = new PortoMaritimo();
            Rota r = new AguaLitoranea();
            
            
            cr.setTipoderota(2);
            cr.setRestricaoderota(1);
            pr.setListaDeNavios(null); 
            lcr.add(cr);
            lrr.add(r);
            
            //Assert.assertThat(lrr.getClass(), is(fr.fabricarRotas(lpr, lcr).getClass()));
            lrrr= fr.fabricarRotas(lpr, lcr);
            Assert.assertEquals(lrr.getClass(),fr.fabricarRotas(lpr, lcr).getClass());
            
            
	}

}
