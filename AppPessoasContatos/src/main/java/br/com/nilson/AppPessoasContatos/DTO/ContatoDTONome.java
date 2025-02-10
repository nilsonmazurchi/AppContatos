package br.com.nilson.AppPessoasContatos.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class ContatoDTONome {
	@Schema(example = "DIGITE O NOME DA PESSOA")
	private String pessoaNome;
	
	@Schema(example = "ESCOLHA:TELEFONE OU CELULAR")
    private String tipoContato;
	
	@Schema(example = "CAMPO ABERTO DESCRIÇÃO")
    private String descContato;
	
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
