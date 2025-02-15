package br.com.nilson.AppPessoasContatos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nilson.AppPessoasContatos.Modelos.Contatos;
import br.com.nilson.AppPessoasContatos.Modelos.Pessoas;

//Interface que define o repositório para a entidade Contatos, estendendo o JpaRepository
//O JpaRepository oferece métodos prontos para CRUD (Create, Read, Update, Delete) e consultas personalizadas.
public interface ContatosRepository extends JpaRepository<Contatos, Long> {
	// Método personalizado para encontrar contatos associados a uma pessoa específica
    // Retorna uma lista de contatos que pertencem à pessoa fornecida
	List<Contatos> findByPessoa(Pessoas pessoa);
}