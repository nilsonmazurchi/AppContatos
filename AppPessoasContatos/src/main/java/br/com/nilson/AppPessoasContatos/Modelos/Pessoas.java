package br.com.nilson.AppPessoasContatos.Modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Classe que representa os dados de uma pessoa, mapeada para a tabela 'tb_pessoas' no banco de dados.
//Contém informações como nome, endereço, cidade, UF e uma lista de contatos associados.
@Entity
@Table(name = "tb_pessoas")
public class Pessoas {
	
	// Atributo que representa o identificador único da entidade
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Atributo que define o nome da pessoa, é uma coluna obrigatória na tabela
	@Column(nullable = false)
	private String nome;	
	
	// Atributo que define o endereço da pessoa
	private String endereco;
	
	// Atributo que define o CEP da pessoa
	private String cep;
	
	// Atributo que define a cidade da pessoa
	private String cidade;
	
	// Atributo que define a unidade federativa (UF) da pessoa
	private String uf;
	
	// Relacionamento OneToMany com a classe Contatos, indicando que uma pessoa pode ter vários contatos
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference 
	private List<Contatos> contatos;
	
	// Métodos Getters e Setters para acessar e modificar os atributos
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public List<Contatos> getContatos() {
		return contatos;
	}
	public void setContatos(List<Contatos> contatos) {
		this.contatos = contatos;
	}
	
	
}
