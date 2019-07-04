package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Chave;
import br.com.senac.servico.ChaveService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller //classe que ira processar requests 
public class ChaveController {
	
		@Autowired //injecao na classe
		private ChaveService chaveService;
	

		@GetMapping("/listarChave") // nome do metodo que ira chamar na url
		public ModelAndView listaChave() {
		ModelAndView mv = new ModelAndView("/paginaChave"); // pagina url
		mv.addObject("chaves", chaveService.listarchave()); // objeto sendo chamado pela classe service
		return mv;
		
		}
		
		
		@GetMapping("/adicionarChave")  
		public ModelAndView add() {  
		ModelAndView	mv = new ModelAndView("/paginaAdicionaChave");
		mv.addObject("chave", new Chave());
		return mv;
		
		}
		
		@PostMapping("/salvar")
		public ModelAndView inserir(Chave chave) {
			chaveService.inserir(chave);
			return listaChave();
		}
		
		
		@GetMapping("/excluirChave/{id}")
		public ModelAndView excluir(@PathVariable("id") Integer idChave) {
			chaveService.excluir(idChave);
			return listaChave();
		}
		
		@GetMapping("/alterarChave/{id}")
		public ModelAndView alterar(@PathVariable("id") Integer idChave) throws ObjectNotFoundException {
			ModelAndView mv = new ModelAndView("/paginaAlterarChave");
			mv.addObject("chave", chaveService.buscar(idChave));
			return mv;
		}
		
		@PostMapping("/alterarChave")
		public ModelAndView alterar( Chave objChave) throws ObjectNotFoundException {
			chaveService.alterar(objChave);
			return listaChave();
		}
		
}
