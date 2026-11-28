package com.krakedev.artesanal.testJUnity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Negocio;

public class TestAsignarCodigoCliente {
	
	@Test

	public void asignarCodigo() { 
		
		Negocio kfc = new Negocio();
		Cliente paula = new Cliente("Paula","123456987");
		Cliente mario = new Cliente("Mario","1236999888");
		
		kfc.asignarCodigoCliente(mario);
		kfc.asignarCodigoCliente(paula);
		
		assertEquals(100, mario.getCodigo());
		assertEquals(101, paula.getCodigo());
		
		
	}
	
}	
