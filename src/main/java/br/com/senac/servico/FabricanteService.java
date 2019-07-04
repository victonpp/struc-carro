package br.com.senac.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Fabricante;
import br.com.senac.repositorio.FabricanteRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class FabricanteService {
	
	@Autowired
	private FabricanteRepositorio repoFabri;
	
	public Fabricante inserir (Fabricante fabricante) {
		fabricante.setId(null);
		return repoFabri.save(fabricante);
	}
	
	public List<Fabricante> listarFabricante(){
		return repoFabri.findAll();
	}
	
	public Fabricante buscar(Integer id) throws ObjectNotFoundException {
		Optional<Fabricante> objFabricante = repoFabri.findById(id);
		return objFabricante.orElseThrow(() -> new ObjectNotFoundException(
				"Fabricante não encontrado Id: " + id + ",  Tipo: " + Fabricante.class.getName()));
	}
	
	
	
	public Fabricante alterar(Fabricante objFabricante) throws ObjectNotFoundException {
		Fabricante obFabricanteEncontrado = buscar(objFabricante.getId());
		obFabricanteEncontrado.setNome(objFabricante.getNome());
		return repoFabri.save(obFabricanteEncontrado);
	}
	
	public void excluir(Integer id) {
		repoFabri.deleteById(id);
	}

}
