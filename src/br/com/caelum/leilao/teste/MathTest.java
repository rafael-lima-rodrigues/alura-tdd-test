package br.com.caelum.leilao.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.math.MatematicaMaluca;

public class MathTest {

	@Test
	public void maiorQue30() {
		int numero =31;
		MatematicaMaluca maluca = new MatematicaMaluca();
		int maior30 = maluca.contaMaluca(numero);
		numero = numero * 4;
		assertEquals(numero, maior30);
	}
	
	@Test
	public void maiorQue10() {
		int numero = 15;
		MatematicaMaluca maluca = new MatematicaMaluca();
		int maior10 = maluca.contaMaluca(numero);
		numero = numero * 3;
		assertEquals(numero, maior10);
	}
	
	@Test
	public void menorQue10() {
		int numero = 4;
		MatematicaMaluca maluca = new MatematicaMaluca();
		int menorQue10 = maluca.contaMaluca(numero);
		numero = numero * 2;
		assertEquals(numero, menorQue10);
	}

}
