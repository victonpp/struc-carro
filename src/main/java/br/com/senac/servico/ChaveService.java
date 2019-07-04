package br.com.senac.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Chave;
import br.com.senac.repositorio.ChaveRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ChaveService {
	
	@Autowired
	private ChaveRepositorio repoChave;
	
	
	public Chave inserir (Chave chave) {
		chave.setId(null);
		return repoChave.save(chave);
	}
	
	public List<Chave> listarchave(){
		return repoChave.findAll();
	}
	
	
	public Chave buscar(Integer id) throws ObjectNotFoundException {
		Optional<Chave> objChave = repoChave.findById(id);
		return objChave.orElseThrow(() -> new ObjectNotFoundException(
				"Chave não encotrada! Id: " + id + ",  Tipo: " + Chave.class.getName()));
	}
	
	
	
	public Chave alterar(Chave objChave) throws ObjectNotFoundException {
		Chave obChaveEncontrado = buscar(objChave.getId());
		
		obChaveEncontrado.setCodigoChave(objChave.getCodigoChave());
		return repoChave.save(obChaveEncontrado);
	}
	
	public void excluir(Integer id) {
		repoChave.deleteById(id);
	}
	
	
}
