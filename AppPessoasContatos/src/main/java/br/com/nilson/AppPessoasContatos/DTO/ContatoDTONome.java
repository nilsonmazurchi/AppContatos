package br.com.nilson.AppPessoasContatos.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO (Data Transfer Object) utilizado para transferir informações de contato
 * baseadas no nome da pessoa.
 */
public class ContatoDTONome {
	// Nome da pessoa associada ao contato
	@Schema(example = "DIGITE O NOME DA PESSOA")
	private String pessoaNome;
	
	// Tipo de contato (exemplo: TELEFONE ou CELULAR)
	@Schema(example = "ESCOLHA:TELEFONE OU CELULAR")
    private String tipoContato;
	
	// Descrição do contato (exemplo: número de telefone.)
	@Schema(example = "CAMPO ABERTO DESCRIÇÃO")
    private String descContato;
	
	// Métodos Getters e Setters para acessar e modificar os atributos
    public String getPessoaNome() {
		return pessoaNome;
	}
	public void setPessoaNome(String pessoaNome) {
		this.pessoaNome = pessoaNome;
	}
	public String getTipoContato() {
		return tipoContato;
	}
	public void setTipoContato(String tipoContato) {
		this.tipoContato = tipoContato;
	}
	public String getDescContato() {
		return descContato;
	}
	public void setDescContato(String descContato) {
		this.descContato = descContato;
	}
    
    
}
