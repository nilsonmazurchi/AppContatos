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

@Entity
@Table(name = "tb_contatos")
public class Contatos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	@Column(nullable = false)
    private TipoContato tipoContato;
	 
	@Column(nullable = false)
	private String descContato;

	@ManyToOne
	@JoinColumn(name = "pessoa", nullable = true)
	 @JsonBackReference
	private Pessoas pessoa;

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
