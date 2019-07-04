package br.com.senac.inicializacao;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.dominio.Acessorio;
import br.com.senac.dominio.Carro;
import br.com.senac.dominio.Chave;
import br.com.senac.dominio.Documento;
import br.com.senac.dominio.Fabricante;
import br.com.senac.servico.AcessorioService;
import br.com.senac.servico.CarroService;
import br.com.senac.servico.ChaveService;
import br.com.senac.servico.DocumentoService;
import br.com.senac.servico.FabricanteService;


@Component
public class Inity implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	CarroService carroService;
	
	@Autowired
	ChaveService chaveService;
	
	@Autowired
	FabricanteService fabricanteService;
	
	@Autowired
	DocumentoService documentoService;
	
	@Autowired
	AcessorioService acessorioService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Chave chave2 = new Chave();
		chave2.setCodigoChave("azul");
		chaveService.inserir(chave2);
		
		Documento documento = new Documento();
		documento.setNome("azul");
		documentoService.inserir(documento);
		
		Fabricante fabricante = new Fabricante();
		fabricante.setNome("siena");
		fabricanteService.inserir(fabricante);
		
		Acessorio acessorio = new Acessorio();
		acessorio.setNome("Video");
		acessorioService.inserir(acessorio);
		
		Acessorio acessorio1 = new Acessorio();
		acessorio1.setNome("Trava");
		acessorioService.inserir(acessorio1);
		
		Acessorio acessorio2 = new Acessorio();
		acessorio2.setNome("ArCondicionado");
		acessorioService.inserir(acessorio2);
		
		Carro carro = new Carro();
		carro.setNome("Gol");
		carro.setChave(chave2);
		carro.setFabi(fabricante);
		carro.setDocumento(documento);
		carro.setAcessorios(Arrays.asList(acessorio));
	
		carroService.inserir(carro);
		
		
		Chave chave1 = new Chave();
		chave1.setCodigoChave("amarela");
		chaveService.inserir(chave1);
		
		Documento documento1= new Documento();
		documento1.setNome("amarelo");
		documentoService.inserir(documento1);
		
		Fabricante fabricante1 = new Fabricante();
		fabricante1.setNome("camaro");
		fabricanteService.inserir(fabricante1);
		
		
		
		Carro carro1 = new Carro();
		carro1.setNome("frod");
		carro1.setChave(chave1);
		carro1.setFabi(fabricante1);
		carro1.setDocumento(documento1);
		carro1.setAcessorios(Arrays.asList(acessorio1));
		carroService.inserir(carro1);
		
		
		
		Chave chave = new Chave();
		chave.setCodigoChave("amarela");
		chaveService.inserir(chave);
		
		Documento documento2= new Documento();
		documento2.setNome("amarelo");
		documentoService.inserir(documento2);
		
		Fabricante fabricante2 = new Fabricante();
		fabricante2.setNome("camaro");
		fabricanteService.inserir(fabricante2);
		
	
		
		Carro carro2= new Carro();
		carro2.setNome("camaro");
		carro2.setChave(chave);
		carro2.setFabi(fabricante);
		carro2.setDocumento(documento2);
		carro2.setAcessorios(Arrays.asList(acessorio2));
		carroService.inserir(carro2);
		
		
		
		
		
	}
		
}
