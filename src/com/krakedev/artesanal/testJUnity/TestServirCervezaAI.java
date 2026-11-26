package com.krakedev.artesanal.testJUnity;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {

	private static final double TOLERANCIA = 0.0001;

	/**
	 * Valida el caso exitoso estándar: la máquina tiene suficiente cerveza,
	 * descuenta la cantidad servida de la cantidad actual y retorna el valor
	 * a pagar (cantidad * precioPorMl).
	 */
	@Test
	public void testServirCervezaExitosa() {
		Maquina maquina = new Maquina("M03","IPA", "Cerveza artesanal lupulada", 0.02, 5000);
		maquina.rellenarMaquina(1000);

		double valorAPagar = maquina.servirCerveza(500);

		assertEquals(10.0, valorAPagar, TOLERANCIA);
		assertEquals(500.0, maquina.getCantidadActual(), TOLERANCIA);
	}

	/**
	 * Valida el caso límite donde se solicita exactamente la misma cantidad
	 * de cerveza disponible en la máquina. Debe servirla, dejar la cantidad
	 * actual en 0 y retornar el valor correcto a pagar.
	 */
	@Test
	public void testServirCantidadExactaDisponible() {
		Maquina maquina = new Maquina("M03","Stout", "Cerveza negra", 0.03);
		maquina.rellenarMaquina(350);

		double valorAPagar = maquina.servirCerveza(350);

		assertEquals(10.5, valorAPagar, TOLERANCIA);
		assertEquals(0.0, maquina.getCantidadActual(), TOLERANCIA);
	}

	/**
	 * Valida el caso en que la cantidad solicitada supera la cerveza disponible.
	 * No debe servir nada, debe retornar 0 y mantener intacta la cantidad actual.
	 */
	@Test
	public void testServirCervezaInsuficiente() {
		Maquina maquina = new Maquina("M03","Lager", "Cerveza rubia", 0.015, 2000);
		maquina.rellenarMaquina(300);

		double valorAPagar = maquina.servirCerveza(500);

		assertEquals(0.0, valorAPagar, TOLERANCIA);
		assertEquals(300.0, maquina.getCantidadActual(), TOLERANCIA);
	}

	/**
	 * Valida el comportamiento cuando la máquina está recién creada (vacía).
	 * Al no tener cerveza disponible, debe retornar 0 y mantener la cantidad actual en 0.
	 */
	@Test
	public void testServirConMaquinaVacia() {
		Maquina maquina = new Maquina("M03","Pilsner", "Cerveza ligera", 0.02);

		double valorAPagar = maquina.servirCerveza(250);

		assertEquals(0.0, valorAPagar, TOLERANCIA);
		assertEquals(0.0, maquina.getCantidadActual(), TOLERANCIA);
	}

	/**
	 * Valida múltiples servicios consecutivos hasta que la cerveza restante
	 * deja de ser suficiente para un nuevo pedido. Verifica que el saldo se
	 * actualice correctamente en cada servicio exitoso y no cambie cuando falla.
	 */
	@Test
	public void testServirMultiplesVecesConsecutivas() {
		Maquina maquina = new Maquina("M03","Amber Ale", "Cerveza roja", 0.025, 3000);
		maquina.rellenarMaquina(1000);

		double primerCobro = maquina.servirCerveza(400);
		assertEquals(10.0, primerCobro, TOLERANCIA);
		assertEquals(600.0, maquina.getCantidadActual(), TOLERANCIA);

		double segundoCobro = maquina.servirCerveza(400);
		assertEquals(10.0, segundoCobro, TOLERANCIA);
		assertEquals(200.0, maquina.getCantidadActual(), TOLERANCIA);

		double tercerCobro = maquina.servirCerveza(300);
		assertEquals(0.0, tercerCobro, TOLERANCIA);
		assertEquals(200.0, maquina.getCantidadActual(), TOLERANCIA);
	}

	/**
	 * Valida el servicio después de llenar la máquina con el método llenarMaquina().
	 * Verifica que se descuente la cantidad solicitada respecto a la cantidad inicial
	 * disponible y que se calcule correctamente el valor a pagar.
	 */
	@Test
	public void testServirDespuesDeLlenarMaquina() {
		Maquina maquina = new Maquina("M03","Porter", "Cerveza oscura", 0.02, 1000);
		maquina.llenarMaquina();
		double cantidadInicial = maquina.getCantidadActual();

		double valorAPagar = maquina.servirCerveza(200);

		assertEquals(4.0, valorAPagar, TOLERANCIA);
		assertEquals(cantidadInicial - 200.0, maquina.getCantidadActual(), TOLERANCIA);
	}

	/**
	 * Valida el caso límite de solicitar 0 mililitros.
	 * Debe retornar 0 y no alterar la cantidad actual de cerveza en la máquina.
	 */
	@Test
	public void testServirCantidadCero() {
		Maquina maquina = new Maquina("M03","Blonde", "Cerveza suave", 0.02, 2000);
		maquina.rellenarMaquina(500);

		double valorAPagar = maquina.servirCerveza(0);

		assertEquals(0.0, valorAPagar, TOLERANCIA);
		assertEquals(500.0, maquina.getCantidadActual(), TOLERANCIA);
	}
}