package br.com.nilson.AppPessoasContatos.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**DTO (Data Transfer Object) para representar os dados de contato de uma pessoa.
 * Utilizado para transferir informações entre a aplicação e a API.
 */
public class ContatoDTO {
	// ID da pessoa a quem o contato pertence (campo obrigatório)
	@NotNull(message = "O ID da pessoa é obrigatório.")
    @Schema(description = "DIGITE O ID DA PESSOA", example = "1")
	private Long pessoaId;
	
	// Tipo de contato (exemplo: TELEFONE ou CELULAR)
	@Schema(example = "ESCOLHA:TELEFONE OU CELULAR")
    private String tipoContato;
	
	// Descrição do contato (exemplo: número de telefone )
	@Schema(example = "CAMPO ABERTO DESCRIÇÃO")
    private String descContato;
	
	// Métodos Getters e Setters para acessar e modificar os atributos
    public Long getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
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
