/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.routesimulator.util.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author DiegoLindo
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({br.edu.ifes.poo2.routesimulator.util.test.FactoryPortoTest.class, br.edu.ifes.poo2.routesimulator.util.test.FactoryRotaTest.class, br.edu.ifes.poo2.routesimulator.util.test.FactoryNavioTest.class, br.edu.ifes.poo2.routesimulator.cdp.test.AbstractNavioTest.class, br.edu.ifes.poo2.routesimulator.cgd.test.RepositorioDeDadosTest.class})
public class AllTests {

    @Before
    public void setUp() throws Exception {
    }
    
}
