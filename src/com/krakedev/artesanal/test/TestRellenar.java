package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRellenar {

	public static void main(String[] args) {

		boolean resultado;

		Maquina rubia = new Maquina("M06","Pilsener", " cerveza rubia ", 0.22, 12000);

		System.out.println("------------------ESTADO INICIAL----------------");

		rubia.imprimir();

		System.out.println("------------------RECARGA 1----------------");

		resultado = rubia.rellenarMaquina(3000);

		System.out.println("Se Recargo Correctamente? " + resultado);

		rubia.imprimir();
		
		System.out.println("------------------RECARGA 2----------------");

		resultado = rubia.rellenarMaquina(6000);

		System.out.println("Se Recargo Correctamente? " + resultado);

		rubia.imprimir();
		
		System.out.println("------------------RECARGA 3----------------");

		resultado = rubia.rellenarMaquina(6000);

		System.out.println("Se Recargo Correctamente? " + resultado);

		rubia.imprimir();
		
		

	}

}
