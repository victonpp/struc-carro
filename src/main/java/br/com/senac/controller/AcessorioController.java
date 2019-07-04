package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Acessorio;
import br.com.senac.servico.AcessorioService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
public class AcessorioController {

	
	@Autowired
	private AcessorioService acessorioService;


	@GetMapping("/listaAcessorio") // nome do metodo que ira chamar na url
	public ModelAndView listaAcessorio() {
	ModelAndView mv = new ModelAndView("/pageA"); // pagina url
	mv.addObject("acessorios",acessorioService.listaracessorio()); // objeto sendo chamado pela classe service
	return mv;
	
	}
	
	@GetMapping("/adicionarAcessorio")  
	public ModelAndView adda() {  
	ModelAndView	mv = new ModelAndView("/paginaAdicionaA");
	mv.addObject("acessorio", new Acessorio());
	return mv;
	
	}
	
	@PostMapping("/salvara")
	public ModelAndView inserira(Acessorio acessorio) {
		acessorioService.inserir(acessorio);
		return listaAcessorio();
	}
	
	
	@GetMapping("/excluirAcessorio/{id}")
	public ModelAndView excluira(@PathVariable("id") Integer idAcessorio) {
		acessorioService.excluir(idAcessorio);
		return listaAcessorio();
	}
	
	@GetMapping("/alterarAcessorio/{id}")
	public ModelAndView alterara(@PathVariable("id") Integer idAcessorio) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("/paginaAlterarAcessorio");
		mv.addObject("acessorio", acessorioService.buscar(idAcessorio));
		return mv;
	}
	
	@PostMapping("/alterarAcessorio")
	public ModelAndView alterara( Acessorio objAcessorio) throws ObjectNotFoundException {
		acessorioService.alterar(objAcessorio);
		return listaAcessorio();
	}
}
