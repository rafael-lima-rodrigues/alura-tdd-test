package br.com.caelum.leilao.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.calendar.AnoBissexto;

public class BissextoTest {

	
	@Test
	public void deveRetornarAnoBissexto() {
		AnoBissexto anoBissexto = new AnoBissexto();
		
		assertEquals(true, anoBissexto.isAnoBissexto(2016));
		assertEquals(true, anoBissexto.isAnoBissexto(2012));
	}
	
	
	@Test
	public void naoDeveRetornarAnoBissexto() {
		AnoBissexto anoBissexto = new AnoBissexto();
		
		assertEquals(false, anoBissexto.isAnoBissexto(2017));
		assertEquals(false, anoBissexto.isAnoBissexto(2013));
	}
}
