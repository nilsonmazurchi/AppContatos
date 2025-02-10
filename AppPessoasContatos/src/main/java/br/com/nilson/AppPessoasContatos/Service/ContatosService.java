package br.com.nilson.AppPessoasContatos.Service;

import br.com.nilson.AppPessoasContatos.Modelos.Contatos;
import br.com.nilson.AppPessoasContatos.Modelos.Pessoas;
import br.com.nilson.AppPessoasContatos.Repository.ContatosRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ContatosService {
    private final ContatosRepository contatosRepository;

    public ContatosService(ContatosRepository contatosRepository) {
        this.contatosRepository = contatosRepository;
    }

    public Contatos salvarContato(Contatos contato) {
        return contatosRepository.save(contato);
    }

    public Optional<Contatos> obterContatoPorId(Long id) {
        return contatosRepository.findById(id);
    }
    
    // Método para obter um Contato pelo ID
    public Contatos obterContatoPorId1(Long id) {
        return contatosRepository.findById(id).orElse(null);  // Retorna o Contato ou null se não encontrado
    }
    
    // Método que retorna todos os contatos de uma pessoa
    public List<Contatos> listarContatosPorPessoa(Pessoas pessoa) {
        return contatosRepository.findByPessoa(pessoa);
    }
    
    // Método para remover um contato pelo ID
    public void removerContato(Long id) {
        contatosRepository.deleteById(id);
    }
}
