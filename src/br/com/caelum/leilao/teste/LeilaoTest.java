package br.com.caelum.leilao.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class LeilaoTest {
	
	@Test
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
		
		Usuario joao = new Usuario("joao");
		Usuario jose = new Usuario("jose");
		
		Leilao leilao = new Leilao("MacBook");
		
		leilao.propoe(new Lance(joao, 2000.0));
		leilao.propoe(new Lance(jose, 3000.0));
		
		leilao.propoe(new Lance(joao, 4000.0));
		leilao.propoe(new Lance(jose, 5000.0));
		
		leilao.propoe(new Lance(joao, 6000.0));
		leilao.propoe(new Lance(jose, 7000.0));
		
		leilao.propoe(new Lance(joao, 8000.0));
		leilao.propoe(new Lance(jose, 9000.0));
		
		leilao.propoe(new Lance(joao, 10000.0));
		leilao.propoe(new Lance(jose, 11000.0));
		
		leilao.propoe(new Lance(joao, 12000.0));
		
		
		assertEquals(10, leilao.getLances().size());
		assertEquals(11000.0, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.00001);
		

	}
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		
		Usuario joao = new Usuario("joao");

		Leilao leilao = new Leilao("MacBook");
		
		leilao.propoe(new Lance(joao, 2000.0));
		leilao.propoe(new Lance(joao, 5000.0));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor());
	}
	
	@Test
	public void deveDobrarOUltimoLanceDado() {
		Leilao leilao = new Leilao("Macbook");
		Usuario steveJobs = new Usuario("Steve");
		Usuario billGates = new Usuario("Bill");
		
		leilao.propoe(new Lance(steveJobs, 1000));
		leilao.propoe(new Lance(billGates, 2000));
		leilao.dobraLance(steveJobs);
		
		assertEquals(2000, leilao.getLances().get(2).getValor(), 0.00001);
	}
	
	@Test
	public void naoDeveDobrarCasoNaoHajaLanceAnterior() {
		Leilao leilao = new Leilao("Mcbook 15");
		Usuario steveJobs = new Usuario("Steve");
		
		leilao.dobraLance(steveJobs);
		
		assertEquals(0, leilao.getLances().size());
	}

}
