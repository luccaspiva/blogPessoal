package br.org.generation.blogPessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Após finalizada a Model, vamos transforma-la em uma entidade do JPA hibernate
@Entity
@Table(name = "tb_tema")
public class Tema {

	@Id //define como PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Define valores automáticos
	private long id; // atributo

	@NotNull //não permite valores nulos
	private String descricao;// atributo
	
	//mapenando o atributo tema na tabela de postagem, onde todas as postagens que pertecem ao devido tema, serão alteradas (cascade)
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL) 
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem; // atibuto Lista do tipo Postagem, chamada postagem

	// gerando GET/SET
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

}
