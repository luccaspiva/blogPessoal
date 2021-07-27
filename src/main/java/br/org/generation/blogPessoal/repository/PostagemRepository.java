package br.org.generation.blogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogPessoal.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{ 
	//Postagem é o mesmo nome que demos na model
	
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	//find All --> busque todos pelo titulo
	//titulo --> nome do atributo da entidade
	//containing --> mesma coisa que o like do SQL, ou seja, tdo que conter os caracteres dessa variavel
	//igneCase --> igona maiusculas e minusculas
	
}
