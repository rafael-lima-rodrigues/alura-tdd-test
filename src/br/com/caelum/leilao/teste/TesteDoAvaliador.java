package br.com.caelum.leilao.teste;

import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.*;;

public class TesteDoAvaliador {

	@Test
	public void entenderLancesOrdemCrescente() {

		//part 1 scenario
		Usuario joao = new Usuario("joao");
		Usuario jose = new Usuario("jose");
		Usuario maria = new Usuario("maria");
		
		Leilao leilao = new Leilao("PS5");
		
		leilao.propoe(new Lance(joao, 1000.00));
		leilao.propoe(new Lance(jose, 2000.00));
		leilao.propoe(new Lance(maria,3000.00));
		
		//part 2 action
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		leiloeiro.avaliaMedia(leilao);
		
		//part 3 validation
		double maiorEsperado = 3000;
		double menorEsperado = 1000;
		
		//System.out.println(maiorEsperado == leiloeiro.getMaiorLance());
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		//System.out.println(menorEsperado == leiloeiro.getMenorLance());
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		//Assert.assertEquals(mediaEsperado, leiloeiro.getMedia(), 0.00001);

	}
	
	@Test
	public void entenderLancesRandom() {

		//part 1 scenario
		Usuario joao = new Usuario("joao");
		Usuario jose = new Usuario("jose");
		Usuario maria = new Usuario("maria");
		
		Leilao leilao = new Leilao("PS5");
		
		leilao.propoe(new Lance(joao, 5000.00));
		leilao.propoe(new Lance(jose, 200.00));
		leilao.propoe(new Lance(maria,3000.00));
		leilao.propoe(new Lance(joao, 4500.00));
		leilao.propoe(new Lance(jose, 2000.00));
		leilao.propoe(new Lance(maria,300.00));
		
		//part 2 action
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		leiloeiro.avaliaMedia(leilao);
		
		//part 3 validation
		double maiorEsperado = 5000;
		double menorEsperado = 200;
		
		//System.out.println(maiorEsperado == leiloeiro.getMaiorLance());
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		//System.out.println(menorEsperado == leiloeiro.getMenorLance());
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		//Assert.assertEquals(mediaEsperado, leiloeiro.getMedia(), 0.00001);

	}
	
	@Test
	public void entenderLancesDecrescente() {

		//part 1 scenario
		Usuario joao = new Usuario("joao");
		Usuario jose = new Usuario("jose");
		Usuario maria = new Usuario("maria");
		
		Leilao leilao = new Leilao("PS5");
		
		leilao.propoe(new Lance(joao, 15000.00));
		leilao.propoe(new Lance(jose, 10000.00));
		leilao.propoe(new Lance(maria,5000.00));
		leilao.propoe(new Lance(joao, 4500.00));
		leilao.propoe(new Lance(jose, 3000.00));
		leilao.propoe(new Lance(maria,2000.00));
		
		//part 2 action
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		leiloeiro.avaliaMedia(leilao);
		
		//part 3 validation
		double maiorEsperado = 15000;
		double menorEsperado = 2000;
		
		//System.out.println(maiorEsperado == leiloeiro.getMaiorLance());
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		//System.out.println(menorEsperado == leiloeiro.getMenorLance());
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		//Assert.assertEquals(mediaEsperado, leiloeiro.getMedia(), 0.00001);

	}
	
	@Test
	public void deveEntenderLeilaoComUmLance() {
		Usuario joao = new Usuario("Jo�o");
		Leilao leilao =  new Leilao("Playstation 3");
		
		leilao.propoe(new Lance(joao, 1000.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(1000.0, leiloeiro.getMenorLance(), 0.00001);
	}

	@Test
	public void tresMaioresLances() {
		
		Usuario joao = new Usuario("Jo�o");
		Usuario maria = new Usuario("Maria");

		Leilao leilao =  new Leilao("Playstation 3");
		
		leilao.propoe(new Lance(joao, 1000.0));
		leilao.propoe(new Lance(maria, 2000.0));
		leilao.propoe(new Lance(joao, 3000.0));
		leilao.propoe(new Lance(maria, 4000.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.maioresLances(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiorres();
		assertEquals(3, maiores.size());
		
		assertEquals(4000.0, maiores.get(0).getValor(), 0.00001);
		assertEquals(3000.0, maiores.get(1).getValor(), 0.00001);
		assertEquals(2000.0, maiores.get(2).getValor(), 0.00001);
		
		
	}

	@Test
	public void doisLances() {
		
		Usuario joao = new Usuario("Jo�o");
		Usuario maria = new Usuario("Maria");

		Leilao leilao =  new Leilao("Playstation 3");
		
		leilao.propoe(new Lance(joao, 1000.0));
		leilao.propoe(new Lance(maria, 2000.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.maioresLances(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiorres();
		assertEquals(2, maiores.size());
		
		assertEquals(2000.0, maiores.get(0).getValor(), 0.00001);
		assertEquals(1000.0, maiores.get(1).getValor(), 0.00001);
		
	}

	@Test
	public void zeroLances() {
		
		Leilao leilao =  new Leilao("Playstation 3");
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.maioresLances(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiorres();
		assertEquals(0, maiores.size());
			
	}
}
