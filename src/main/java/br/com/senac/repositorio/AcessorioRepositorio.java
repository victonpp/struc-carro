package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.Acessorio;

@Repository
public interface AcessorioRepositorio extends JpaRepository<Acessorio, Integer> {

}
