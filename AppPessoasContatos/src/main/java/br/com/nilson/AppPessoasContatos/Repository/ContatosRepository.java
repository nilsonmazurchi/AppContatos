package br.com.nilson.AppPessoasContatos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nilson.AppPessoasContatos.Modelos.Contatos;
import br.com.nilson.AppPessoasContatos.Modelos.Pessoas;

public interface ContatosRepository extends JpaRepository<Contatos, Long> {
	List<Contatos> findByPessoa(Pessoas pessoa);
}