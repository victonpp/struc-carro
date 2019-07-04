package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.senac.dominio.Documento;

import br.com.senac.servico.DocumentoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
public class DocumentoController {
	
	@Autowired
	private DocumentoService documentoService;


	@GetMapping("/listarDocumento") // nome do metodo que ira chamar na url
	public ModelAndView listaDocumento() {
	ModelAndView mv = new ModelAndView("/paginaDocumento"); // pagina url
	mv.addObject("documentos",documentoService.listardocumento()); // objeto sendo chamado pela classe service
	return mv;
	
	}
	
	@GetMapping("/adicionarDocumento")  
	public ModelAndView addd() {  
	ModelAndView	mv = new ModelAndView("/paginaAdicionaD");
	mv.addObject("documento", new Documento());
	return mv;
	
	}
	
	@PostMapping("/salvard")
	public ModelAndView inserird(Documento documento) {
		documentoService.inserir(documento);
		return listaDocumento();
	}
	
	
	@GetMapping("/excluirDocumento/{id}")
	public ModelAndView excluird(@PathVariable("id") Integer idDocumento) {
		documentoService.excluir(idDocumento);
		return listaDocumento();
	}
	
	@GetMapping("/alterarDocumento/{id}")
	public ModelAndView alterard(@PathVariable("id") Integer idDocumento) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("/paginaAlterarDocumento");
		mv.addObject("documento", documentoService.buscar(idDocumento));
		return mv;
	}
	
	@PostMapping("/alterarDocumento")
	public ModelAndView alterard( Documento objDocumento) throws ObjectNotFoundException {
		documentoService.alterar(objDocumento);
		return listaDocumento();
	}
	

}
