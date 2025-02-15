package br.com.nilson.AppPessoasContatos.Repository;

import br.com.nilson.AppPessoasContatos.Modelos.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface que define o repositório para a entidade Pessoas, estendendo o JpaRepository
//O JpaRepository oferece métodos prontos para CRUD (Create, Read, Update, Delete) e consultas personalizadas.
public interface PessoasRepository extends JpaRepository<Pessoas, Long> {
	// Método personalizado para encontrar uma pessoa com base no nome
    // Retorna a pessoa que possui o nome fornecido como parâmetro
	Pessoas findByNome(String nome);
}