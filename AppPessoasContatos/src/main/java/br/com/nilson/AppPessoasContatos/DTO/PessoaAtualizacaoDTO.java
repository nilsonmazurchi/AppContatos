package br.com.nilson.AppPessoasContatos.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados para atualização de uma pessoa")
public class PessoaAtualizacaoDTO {

	@Schema(description = "Nome da pessoa", example = "")
    private String nome;

	@Schema(description = "Endereço da pessoa", example = "")
    private String endereco;

	@Schema(description = "CEP da pessoa", example = "")
    private String cep;

	@Schema(description = "Cidade da pessoa", example = "")
    private String cidade;

	@Schema(description = "UF da pessoa", example = "")
    private String uf;

    // Getters e Setters
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
