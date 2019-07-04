package br.com.senac.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.senac.dominio.Carro;
import br.com.senac.dominio.Chave;
import br.com.senac.repositorio.CarroRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepositorio repoCarro;
	
	
	public Carro inserir (Carro carro) {
		carro.setId(null);
		return repoCarro.save(carro);
	}
	
	public List<Carro> listarCarro(){
		return repoCarro.findAll();
	}
	
	
	public Carro buscar(Integer id) throws ObjectNotFoundException {
		Optional<Carro> objCarro = repoCarro.findById(id);
		return objCarro.orElseThrow(() -> new ObjectNotFoundException(
				"Carro não encotrada! Id: " + id + ",  Tipo: " + Chave.class.getName()));
	}
	
	
	
	public Carro alterar(Carro objCarro) throws ObjectNotFoundException {
		Carro obCarroEncontrado = buscar(objCarro.getId());
		obCarroEncontrado.setNome(objCarro.getNome());
		return repoCarro.save(obCarroEncontrado);
	}
	
	public void excluir(Integer id) {
		repoCarro.deleteById(id);
	}
	
	
}
