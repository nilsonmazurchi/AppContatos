package br.com.nilson.AppPessoasContatos.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO (Data Transfer Object) utilizado para a atualização dos dados de uma pessoa.
 * Permite modificar atributos específicos sem precisar recriar todo o objeto.
 */
@Schema(description = "Dados para atualização de uma pessoa")
public class PessoaAtualizacaoDTO {

	// Atributo que representa o nome da pessoa
	@Schema(description = "Nome da pessoa", example = "")
    private String nome;

	 // Atributo que representa o endereço da pessoa
	@Schema(description = "Endereço da pessoa", example = "")
    private String endereco;

	// Atributo que representa o CEP da pessoa
	@Schema(description = "CEP da pessoa", example = "")
    private String cep;

	// Atributo que representa a cidade da pessoa
	@Schema(description = "Cidade da pessoa", example = "")
    private String cidade;

	 // Atributo que representa a unidade federativa (UF) da pessoa
	@Schema(description = "UF da pessoa", example = "")
    private String uf;

	// Métodos Getters e Setters para acessar e modificar os atributos
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
    
    
}
