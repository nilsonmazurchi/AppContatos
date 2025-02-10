package br.com.nilson.AppPessoasContatos.Service;

import br.com.nilson.AppPessoasContatos.Modelos.Pessoas;
import br.com.nilson.AppPessoasContatos.Repository.PessoasRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoasService {

    @Autowired
    private PessoasRepository pessoasRepository;

    public Pessoas criarPessoa(Pessoas novaPessoa) {
        // Aqui você pode adicionar lógica de validação ou outros processos de negócio
        return pessoasRepository.save(novaPessoa);
    }
    
    // Método para obter pessoa por ID
    public Pessoas obterPessoaPorId(Long id) {
        return pessoasRepository.findById(id).orElse(null); // Retorna null se não encontrar
    }
    // Método para listar todas as pessoas
    public List<Pessoas> listarTodasPessoas() {
        return pessoasRepository.findAll(); // Retorna todas as pessoas no banco de dados
    }
    
    // Método para atualizar uma pessoa
    public Pessoas atualizarPessoa(Pessoas pessoaAtualizada) {
        return pessoasRepository.save(pessoaAtualizada); // Atualiza os dados no banco de dados
    }
    
    // Método para apagar uma pessoa por id
    public void removerPessoa(Long id) {
        pessoasRepository.deleteById(id);
    }
    
    // Método para obter pessoa por nome
    public Pessoas obterPessoaPorNome(String nome) {
        return pessoasRepository.findByNome(nome); // Aqui estamos assumindo que existe um método `findByNome` no repositório
    }
}
