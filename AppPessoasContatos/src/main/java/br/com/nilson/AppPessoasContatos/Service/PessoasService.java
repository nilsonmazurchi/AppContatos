package br.com.nilson.AppPessoasContatos.Service;

import br.com.nilson.AppPessoasContatos.Modelos.Pessoas;
import br.com.nilson.AppPessoasContatos.Repository.PessoasRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Classe de serviço que contém a lógica de negócios para manipulação das pessoas
@Service
public class PessoasService {

    @Autowired
    private PessoasRepository pessoasRepository;

    // Método para criar uma nova pessoa
    // Aqui você pode adicionar lógica de validação ou outros processos de negócio antes de salvar
    public Pessoas criarPessoa(Pessoas novaPessoa) {        
        return pessoasRepository.save(novaPessoa);  // Salva a nova pessoa no banco de dados
    }
    
    // Método para obter pessoa por ID
    // Retorna null se não encontrar a pessoa com o ID fornecido
    public Pessoas obterPessoaPorId(Long id) {
        return pessoasRepository.findById(id).orElse(null); // Retorna null se não encontrar
    }
    
    // Método para listar todas as pessoas cadastradas no banco de dados
    public List<Pessoas> listarTodasPessoas() {
        return pessoasRepository.findAll(); // Retorna todas as pessoas no banco de dados
    }
    
    // Método para atualizar os dados de uma pessoa
    // Salva a pessoa no banco de dados, atualizando os dados existentes
    public Pessoas atualizarPessoa(Pessoas pessoaAtualizada) {
        return pessoasRepository.save(pessoaAtualizada); // Atualiza os dados no banco de dados
    }
    
    // Método para remover uma pessoa do banco de dados utilizando seu ID
    public void removerPessoa(Long id) {
        pessoasRepository.deleteById(id); // Apaga a pessoa com o ID fornecido
    }
    
    // Método para obter uma pessoa pelo nome
    // Retorna uma pessoa específica com base no nome fornecido
    public Pessoas obterPessoaPorNome(String nome) {
        return pessoasRepository.findByNome(nome); // Aqui estamos assumindo que existe um método `findByNome` no repositório
    }
}
