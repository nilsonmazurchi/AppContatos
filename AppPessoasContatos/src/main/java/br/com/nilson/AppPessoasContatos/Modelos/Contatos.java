package br.com.nilson.AppPessoasContatos.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Classe que representa os dados de um contato, mapeada para a tabela 'tb_contatos' no banco de dados.
//Contém informações como tipo de contato, descrição do contato e a associação com uma pessoa.
@Entity
@Table(name = "tb_contatos")
public class Contatos {
	
	// Atributo que representa o identificador único da entidad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Atributo que define o tipo de contato, é uma coluna obrigatória na tabela
	@Column(nullable = false)
    private TipoContato tipoContato;

	 // Atributo que descreve o contato, também obrigatório
	@Column(nullable = false)
	private String descContato;

	// Relacionamento ManyToOne com a classe Pessoas, indicando que um contato pertence a uma pessoa
	@ManyToOne
	@JoinColumn(name = "pessoa", nullable = true)
	@JsonBackReference
	private Pessoas pessoa;

	
	// Métodos Getters e Setters para acessar e modificar os atributos
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoas getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoas pessoa) {
		this.pessoa = pessoa;
	}

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

	public String getDescContato() {
		return descContato;
	}

	public void setDescContato(String descContato) {
		this.descContato = descContato;
	}
	
	
	
}
