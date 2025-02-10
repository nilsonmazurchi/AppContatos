package br.com.nilson.AppPessoasContatos.Repository;

import br.com.nilson.AppPessoasContatos.Modelos.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoasRepository extends JpaRepository<Pessoas, Long> {
    // Aqui você pode adicionar consultas customizadas, se necessário
	Pessoas findByNome(String nome);
}