package br.com.senac.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.senac.dominio.Documento;

import br.com.senac.repositorio.DocumentoRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class DocumentoService {
	
	@Autowired
	private DocumentoRepositorio repoDoc;

	public Documento inserir (Documento documento) {
		documento.setId(null);
		return repoDoc.save(documento);
	}
	
	public List<Documento> listardocumento(){
		return repoDoc.findAll();
	}
	
	public Documento buscar(Integer id) throws ObjectNotFoundException {
		Optional<Documento> objDocumento = repoDoc.findById(id);
		return objDocumento.orElseThrow(() -> new ObjectNotFoundException(
				"Documento não encontrado Id: " + id + ",  Tipo: " + Documento.class.getName()));
	}
	
	
	
	public Documento alterar(Documento objDocumento) throws ObjectNotFoundException {
		Documento obDocumentoEncontrado = buscar(objDocumento.getId());
		obDocumentoEncontrado.setNome(objDocumento.getNome());
		return repoDoc.save(obDocumentoEncontrado);
	}
	
	public void excluir(Integer id) {
		repoDoc.deleteById(id);
	}

}
	

