package br.com.senac.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Acessorio;
import br.com.senac.repositorio.AcessorioRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AcessorioService {
	

	@Autowired
	private AcessorioRepositorio repoAcess;
	
	
	public Acessorio inserir (Acessorio acessorio) {
		acessorio.setId(null);
		return repoAcess.save(acessorio);
	}
	
	public List<Acessorio> listaracessorio(){
		return repoAcess.findAll();
	}
	
	public Acessorio buscar(Integer id) throws ObjectNotFoundException {
		Optional<Acessorio> objAcessorio = repoAcess.findById(id);
		return objAcessorio.orElseThrow(() -> new ObjectNotFoundException(
				"Acessorio não encontrado Id: " + id + ",  Tipo: " + Acessorio.class.getName()));
	}
	
	
	
	public Acessorio alterar(Acessorio objAcessorio) throws ObjectNotFoundException {
		Acessorio obAcessorioEncontrado = buscar(objAcessorio.getId());
		obAcessorioEncontrado.setNome(objAcessorio.getNome());
		return repoAcess.save(obAcessorioEncontrado);
	}
	
	public void excluir(Integer id) {
		repoAcess.deleteById(id);
	}

}
