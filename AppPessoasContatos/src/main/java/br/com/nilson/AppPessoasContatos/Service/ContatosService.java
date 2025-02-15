package br.com.nilson.AppPessoasContatos.Service;

import br.com.nilson.AppPessoasContatos.Modelos.Contatos;
import br.com.nilson.AppPessoasContatos.Modelos.Pessoas;
import br.com.nilson.AppPessoasContatos.Repository.ContatosRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

//Classe de serviço que contém a lógica de negócios para manipulação dos contatos
@Service
public class ContatosService {
	// Repositório para realizar operações CRUD nos contatos
	private final ContatosRepository contatosRepository;

	// Construtor que injeta o repositório de contatos
    public ContatosService(ContatosRepository contatosRepository) {
        this.contatosRepository = contatosRepository;
    }

    // Método para salvar um novo contato ou atualizar um existente
    public Contatos salvarContato(Contatos contato) {
        return contatosRepository.save(contato); // Salva o contato no banco de dados
    }

    // Método para obter um contato por seu ID, retornando um Optional para lidar com valores ausentes
    public Optional<Contatos> obterContatoPorId(Long id) {
        return contatosRepository.findById(id); // Retorna um Optional com o contato ou vazio se não encontrado
    }
    
    // Método para obter um contato por seu ID, retornando o próprio contato ou null se não encontrado
    public Contatos obterContatoPorId1(Long id) {
        return contatosRepository.findById(id).orElse(null);  // Retorna o Contato ou null se não encontrado
    }
    
    // Método que retorna todos os contatos de uma pessoa
    public List<Contatos> listarContatosPorPessoa(Pessoas pessoa) {
        return contatosRepository.findByPessoa(pessoa); // Retorna a lista de contatos da pessoa fornecida
    }
    
    // Método para remover um contato pelo ID
    public void removerContato(Long id) {
        contatosRepository.deleteById(id); // Remove o contato com o ID fornecido
    }
}
