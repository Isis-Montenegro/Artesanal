package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Maquina rubia = new Maquina("M04","Pilsener ","cerveza rubia ",0.23,12000);
		
		rubia.imprimir();
		
		rubia.setNombreCerveza("Heineken");
		rubia.setDescripcion("Cerveza de origen neerlandés");
		rubia.imprimir();
		
		
		Maquina negra = new Maquina("M04","Pilsener ", "cerveza rubia ", 0.23);
	    negra.setNombreCerveza("Heineken");
	    negra.setDescripcion("Cerveza de origen neerlandés");
	    negra.imprimir();
	}
	
		

}
