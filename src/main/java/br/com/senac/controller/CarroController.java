package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Carro;
import br.com.senac.servico.CarroService;
import javassist.tools.rmi.ObjectNotFoundException;


@Controller
public class CarroController {
		
	@Autowired
	private CarroService carroService;


	@GetMapping("/listarCarro") // nome do metodo que ira chamar na url
	public ModelAndView listarCarro() {
	ModelAndView mv = new ModelAndView("/paginaCarro"); // pagina url
	mv.addObject("carro",carroService.listarCarro()); // objeto sendo chamado pela classe service
	return mv;
	
	}

	
	@GetMapping("/adicionarCarro")  
	public ModelAndView addcarro() {  
	ModelAndView	mv = new ModelAndView("/paginaAdicionaCarro");
	mv.addObject("carro", new Carro());
	return mv;
	
	}
	
	@PostMapping("/salvarr")
	public ModelAndView inserirr(Carro carro) {
		carroService.inserir(carro);
		return listarCarro();
	}
	
	
	@GetMapping("/excluirCarro/{id}")
	public ModelAndView excluir(@PathVariable("id") Integer idCarro) {
		carroService.excluir(idCarro);
		return listarCarro();
	}
	
	@GetMapping("/alterarCarro/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer idCarro) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("/paginaAlterarCarro");
		mv.addObject("carro", carroService.buscar(idCarro));
		return mv;
	}
	
	@PostMapping("/alterarCarro")
	public ModelAndView alterar( Carro objCarro) throws ObjectNotFoundException {
		carroService.alterar(objCarro);
		return listarCarro();
	}
	
}

