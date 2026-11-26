package com.krakedev.artesanal.testJUnity;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {
	
	@Test
	public void testRecargaExitosa() { 
		
		Maquina rubia = new Maquina("M02","Pilsener "," cerveza", 0.02,8000);
		
		boolean resultado = rubia.rellenarMaquina(3000);
		
		assertTrue(resultado);
		assertEquals(3000, rubia.getCantidadActual(),0.0001);
	}
	
	@Test
	public void testRecargaFallidaPorDesborde() { 
		
		Maquina negra = new Maquina("M02","Club "," cerveza fria", 0.04,8000);
		
		negra.rellenarMaquina(7000);
		
		boolean resultado = negra.rellenarMaquina(1000);
		
		assertTrue(resultado);
		assertEquals(3000, negra.getCantidadActual(),0.0001);
	}

}
