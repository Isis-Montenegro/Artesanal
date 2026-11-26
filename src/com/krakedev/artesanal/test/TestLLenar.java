package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLLenar {

	public static void main(String[] args) {

		Maquina rubia = new Maquina("M05"," Pilsener", " cerveza rubia ", 0.22, 12000);

		rubia.imprimir();

		rubia.llenarMaquina();

		rubia.imprimir();

		Maquina negra = new Maquina("M05","Club ", "Cerveza fria", 0.85);

		negra.imprimir();

		negra.llenarMaquina();

		negra.imprimir();

	}

}
