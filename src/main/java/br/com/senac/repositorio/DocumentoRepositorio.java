package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.Documento;

@Repository
public interface DocumentoRepositorio extends JpaRepository<Documento, Integer>{

}
