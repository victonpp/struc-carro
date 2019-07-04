package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.senac.dominio.Fabricante;
import br.com.senac.servico.FabricanteService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
public class FabricanteController {
		

	@Autowired
	private FabricanteService fabricanteService;


	@GetMapping("/listaFabricante") // nome do metodo que ira chamar na url
	public ModelAndView listaFabricante() {
	ModelAndView mv = new ModelAndView("/paginaFabricante"); // pagina url
	mv.addObject("fabricantes",fabricanteService.listarFabricante()); // objeto sendo chamado pela classe service
	return mv;
	
	}
	
	@GetMapping("/adicionarFabricante")  
	public ModelAndView addf() {  
	ModelAndView	mv = new ModelAndView("/paginaAdicionaF");
	mv.addObject("fabricante", new Fabricante());
	return mv;
	
	}
	
	@PostMapping("/salvarf")
	public ModelAndView inserirf(Fabricante fabricante) {
		fabricanteService.inserir(fabricante);
		return listaFabricante();
	}
	
	
	@GetMapping("/excluirFabricante/{id}")
	public ModelAndView excluirf(@PathVariable("id") Integer idFabricante) {
		fabricanteService.excluir(idFabricante);
		return listaFabricante();
	}
	
	@GetMapping("/alterarFabricante/{id}")
	public ModelAndView alterarf(@PathVariable("id") Integer idFabricante) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("/paginaAlterarFabricante");
		mv.addObject("fabricante", fabricanteService.buscar(idFabricante));
		return mv;
	}
	
	@PostMapping("/alterarFabricante")
	public ModelAndView alterarf( Fabricante objFabricante) throws ObjectNotFoundException {
		fabricanteService.alterar(objFabricante);
		return listaFabricante();
	}
	
}
