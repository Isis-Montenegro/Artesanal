package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Maquina rubia = new Maquina("M07","Rubia", "Cerveza Fria",0.02, 12000);
		
		System.out.println("-----------ESTADO INICIAL-----------");
		rubia.imprimir();
		
		System.out.println("-------------LLENANDO--------------");
		rubia.rellenarMaquina(5000);
		rubia.imprimir();
		
		System.out.println("-------------SERVIR 2000ml---------------");
		double valor;
		
		valor = rubia.servirCerveza(2000);
		
		System.out.println("VALOR A PAGAR: " + valor);
		
	}

}
