package br.org.generation.blogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.generation.blogPessoal.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long>{
	
	//Tdo que contém na palavra buscada, será retornado
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);

}
