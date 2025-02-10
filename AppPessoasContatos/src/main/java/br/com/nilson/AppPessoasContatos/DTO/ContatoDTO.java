package br.com.nilson.AppPessoasContatos.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class ContatoDTO {
	@NotNull(message = "O ID da pessoa é obrigatório.")
    @Schema(description = "DIGITE O ID DA PESSOA", example = "1")
	private Long pessoaId;
	
	@Schema(example = "ESCOLHA:TELEFONE OU CELULAR")
    private String tipoContato;
	
	@Schema(example = "CAMPO ABERTO DESCRIÇÃO")
    private String descContato;
	
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
